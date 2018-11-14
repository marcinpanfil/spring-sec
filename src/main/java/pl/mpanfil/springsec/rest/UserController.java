package pl.mpanfil.springsec.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pl.mpanfil.springsec.user.User;
import pl.mpanfil.springsec.user.UserService;

import java.net.URI;

@RestController
@RequestMapping(value = "/api/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE,
        consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public ResponseEntity<Void> user() {
        return ResponseEntity.ok().build();
    }

    @PostMapping
    public ResponseEntity<Void> add(@RequestBody User user) {
        userService.save(user);
        return ResponseEntity.created(URI.create("/api/user")).build();
    }

}
