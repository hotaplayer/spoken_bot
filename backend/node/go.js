const { Configuration, OpenAIApi } = require("openai");
const configuration = new Configuration({
  apiKey: "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",
});
const openai = new OpenAIApi(configuration);

async function main(){
    const response = await openai.createCompletion({
        model: "text-davinci-003",
        prompt: "Say this is a test",
        temperature: 0,
        max_tokens: 7,
      });

      console.log(response)
}

main();

@RestController
public class LoginController {

    @Autowired
    private LoginService loginService;

    @PostMapping("/register")
    public ResponseEntity<String> register(@RequestBody User user) {
        return loginService.register(user);
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user) {
        return loginService.login(user);
    }

}

Service:

@Service
public class LoginService {

    @Autowired
    private UserMapper userMapper;

    public ResponseEntity<String> register(User user) {
        if (userMapper.findByUsername(user.getUsername()) != null) {
            return new ResponseEntity<>("Username already exists", HttpStatus.BAD_REQUEST);
        }
        userMapper.insert(user);
        return new ResponseEntity<>("User registered successfully", HttpStatus.OK);
    }

    public ResponseEntity<String> login(User user) {
        User userFromDb = userMapper.findByUsername(user.getUsername());
        if (userFromDb == null) {
            return new ResponseEntity<>("Username not found", HttpStatus.BAD_REQUEST);
        }
        if (!userFromDb.getPassword().equals(user.getPassword())) {
            return new ResponseEntity<>("Incorrect password", HttpStatus.BAD_REQUEST);
        }
        return new ResponseEntity<>("Login successful", HttpStatus.OK);
    }

}

MyBatis Mapper:

@Mapper
public interface UserMapper {

    @Insert("INSERT INTO users (username, password) VALUES (#{username}, #{password})")
    void insert(User user);

    @Select("SELECT * FROM users WHERE username = #{username}")
    User findByUsername(String username);

}
