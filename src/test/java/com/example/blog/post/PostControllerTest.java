package com.example.blog.post;

import com.example.blog.post.Post;
import com.example.blog.post.PostRepository;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.MockitoAnnotations;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import static org.assertj.core.api.Assertions.assertThat;
// import org.springframework.boot.test.web.client.TestRestTemplate;

import static org.mockito.Mockito.*;
import org.springframework.beans.factory.annotation.Autowired; // Make sure this import is present

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostControllerTest {
    
    @Autowired
    TestRestTemplate restTemplate;

    // @Autowired
    // private MockMvc mockMvc;

    // @MockBean
    // private PostRepository postRepository;

    // @InjectMocks
    // private PostController postController;

    // @BeforeEach
    // public void setUp() {
    //     MockitoAnnotations.openMocks(this);
    // }

    // @Test
    // public void testGetAllPosts() throws Exception {
    //     List<Post> postList = new ArrayList<>();
    //     postList.add(new Post(1, "Title 1", "Content 1"));
    //     postList.add(new Post(2, "Title 2", "Content 2"));

    //     when(postRepository.findAll()).thenReturn(postList);

    //     mockMvc.perform(MockMvcRequestBuilders.get("/posts")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(MockMvcResultMatchers.status().isOk())
    //             .andExpect(MockMvcResultMatchers.jsonPath("$").isArray())
    //             .andExpect(MockMvcResultMatchers.jsonPath("$.length()").value(postList.size()));
    // }

    // @Test
    // public void testCreatePost() throws Exception {
    //     Post post = new Post(1, "Title", "Content");

    //     when(postRepository.save(any(Post.class))).thenReturn(post);

    //     mockMvc.perform(MockMvcRequestBuilders.post("/posts")
    //             .content("{\"id\":1,\"title\":\"Title\",\"content\":\"Content\"}")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(MockMvcResultMatchers.status().isOk())
    //             .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(post.getId()))
    //             .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(post.getTitle()))
    //             .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(post.getContent()));
    // }

    // @Test
    // public void testUpdatePost() throws Exception {
    //     Post post = new Post(1, "Updated Title", "Updated Content");

    //     when(postRepository.save(any(Post.class))).thenReturn(post);

    //     mockMvc.perform(MockMvcRequestBuilders.put("/posts")
    //             .content("{\"id\":1,\"title\":\"Updated Title\",\"content\":\"Updated Content\"}")
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(MockMvcResultMatchers.status().isOk())
    //             .andExpect(MockMvcResultMatchers.jsonPath("$.id").value(post.getId()))
    //             .andExpect(MockMvcResultMatchers.jsonPath("$.title").value(post.getTitle()))
    //             .andExpect(MockMvcResultMatchers.jsonPath("$.content").value(post.getContent()));
    // }

    // @Test
    // public void testDeletePost() throws Exception {
    //     // Mock the behavior of the findById method to return a post with ID 1
    //     when(postRepository.findById(1)).thenReturn(Optional.of(new Post(1, "Title", "Content")));

    //     // Mock the behavior of the delete method to do nothing
    //     doNothing().when(postRepository).delete(any(Post.class));

    //     mockMvc.perform(MockMvcRequestBuilders.delete("/posts/{id}", 1)
    //             .contentType(MediaType.APPLICATION_JSON))
    //             .andExpect(MockMvcResultMatchers.status().isOk());
    // }

    @Test
    void testGetPost() {
    ResponseEntity<String> response = restTemplate.withBasicAuth("sarah1", "abc123").getForEntity("/posts/1", String.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

    @Test
    void testGetAllPosts() {
    ResponseEntity<String> response = restTemplate.withBasicAuth("sarah1", "abc123").getForEntity("/posts/", String.class);
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
    }

//     @Test
//     void testCreatePost() {
//     ResponseEntity<String> response = restTemplate.withBasicAuth("sarah1", "abc123").postForEntity("/posts/", "{\"title\":\"Title\",\"content\":\"Content\"}", String.class);
//     assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
// }

@Test
void testCreatePost() {
  

    String postJson = "{\"title\":\"Title\",\"content\":\"Content\"}";
    HttpHeaders headers = new HttpHeaders();
    headers.setContentType(MediaType.APPLICATION_JSON);

    // headers.setBasicAuth("sarah1", "abc123");
    HttpEntity<String> requestEntity = new HttpEntity<>(postJson, headers);

    // Act
    
    ResponseEntity<String> response = restTemplate.postForEntity("/posts/", requestEntity, String.class);

    // Assert
    assertThat(response.getStatusCode()).isEqualTo(HttpStatus.OK);
}


}
