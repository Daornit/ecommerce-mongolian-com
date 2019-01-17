package mongolian.ecommerce.com.Controllers;

import mongolian.ecommerce.com.Application;
import mongolian.ecommerce.com.DAO.PostNewDAO;
import mongolian.ecommerce.com.Entities.PostNew;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.hateoas.Resource;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import static org.springframework.hateoas.mvc.ControllerLinkBuilder.linkTo;
import static org.springframework.hateoas.mvc.ControllerLinkBuilder.methodOn;

@RestController
@RequestMapping("/api/news")
public class PostNewsController {

    private static final Logger log = LoggerFactory.getLogger(Application.class);

    @Autowired
    private PostNewDAO postNewDAO;

    @GetMapping()
    public @ResponseBody List<PostNew> retrieveAllPostedNews(){
        for(PostNew post : postNewDAO.findAll()){
            log.info(post.toString());
        }
        return postNewDAO.findAll();
    }
    @RequestMapping(value = "/{id}",method = RequestMethod.GET, produces = {"application/hal+json"})
    public Resource<PostNew> retrievePostedNew(@PathVariable long id) {
        Optional<PostNew> postedNew = postNewDAO.findById(id);
        Resource<PostNew> resource = new Resource<PostNew>(postedNew.get());
        ControllerLinkBuilder linkTo = linkTo(methodOn(this.getClass()).retrieveAllPostedNews());
        resource.add(linkTo.withRel("all-news"));
        return resource;
    }
    @PostMapping()
    public ResponseEntity<Object> createStudent(@RequestBody PostNew postNew) {
        PostNew savedPostNew = postNewDAO.save(postNew);
        log.info(savedPostNew.toString());
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(savedPostNew.getId()).toUri();
        return ResponseEntity.ok(location);
    }
}
