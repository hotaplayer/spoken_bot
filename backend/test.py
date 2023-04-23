import base64
import openai
from config import config
#
openai.api_key = config.get("openai_api_key")

def test():
    # response = openai.Completion.create(model="code-davinci-002", prompt="I have a springboot project, with HelloWord contract to call.It also have a controller to call this smart contract. Need a standard register/login controller and service using mybatis. Show me the code", temperature=0, max_tokens=7)
    # response = openai.Completion.create(model="text-davinci-003", prompt="I have a springboot project, with HelloWord contract to call.It also have a controller to call this smart contract. Need a standard register/login controller and service using mybatis. Show me the code", temperature=0, max_tokens=800)
    # print(response)
    x =   ".\n\nController:\n\n@RestController\npublic class LoginController {\n\n    @Autowired\n    private LoginService loginService;\n\n    @PostMapping(\"/register\")\n    public ResponseEntity<String> register(@RequestBody User user) {\n        return loginService.register(user);\n    }\n\n    @PostMapping(\"/login\")\n    public ResponseEntity<String> login(@RequestBody User user) {\n        return loginService.login(user);\n    }\n\n}\n\nService:\n\n@Service\npublic class LoginService {\n\n    @Autowired\n    private UserMapper userMapper;\n\n    public ResponseEntity<String> register(User user) {\n        if (userMapper.findByUsername(user.getUsername()) != null) {\n            return new ResponseEntity<>(\"Username already exists\", HttpStatus.BAD_REQUEST);\n        }\n        userMapper.insert(user);\n        return new ResponseEntity<>(\"User registered successfully\", HttpStatus.OK);\n    }\n\n    public ResponseEntity<String> login(User user) {\n        User userFromDb = userMapper.findByUsername(user.getUsername());\n        if (userFromDb == null) {\n            return new ResponseEntity<>(\"Username not found\", HttpStatus.BAD_REQUEST);\n        }\n        if (!userFromDb.getPassword().equals(user.getPassword())) {\n            return new ResponseEntity<>(\"Incorrect password\", HttpStatus.BAD_REQUEST);\n        }\n        return new ResponseEntity<>(\"Login successful\", HttpStatus.OK);\n    }\n\n}\n\nMyBatis Mapper:\n\n@Mapper\npublic interface UserMapper {\n\n    @Insert(\"INSERT INTO users (username, password) VALUES (#{username}, #{password})\")\n    void insert(User user);\n\n    @Select(\"SELECT * FROM users WHERE username = #{username}\")\n    User findByUsername(String username);\n\n}"
    print(x)

if __name__ == "__main__":
    test()