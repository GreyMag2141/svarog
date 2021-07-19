package com.example.svarog.controllers;

import com.example.svarog.exceptions.NotFoundException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("message")
//@Api(tags = "MainController", description = "API for svarog")
public class MainController {
//    @ApiOperation(value = "getProduct", nickname = "getHello")
//    @ApiResponses(value = {
//            @ApiResponse(code = 500, message = "Server error"),
//            @ApiResponse(code = 200, message = "Successful",
//                    response = Process.class)})
//    @RequestMapping(method = RequestMethod.GET, value = "/getHello")
//    public String getHello(@RequestParam String name) {
//        return "hello " + name;
//    }
      private int counter =4;

      private List<Map<String,String>> messages = new ArrayList<Map<String,String>>() {{
              add(new HashMap<String, String>() {{put("id", "1");put("text", "First message");}});
              add(new HashMap<String, String>() {{put("id", "2");put("text", "Second message");}});
              add(new HashMap<String, String>() {{put("id", "3");put("text", "Third message");}});
          }};
      @GetMapping
    public List<Map<String,String>> list() {
          return messages;
          }
       @GetMapping("{id}")
       public Map<String,String> getOne(@PathVariable String id) {
          return getMessage(id);
              }
    private Map<String, String> getMessage(String id) {
          return messages.stream()
                .filter(message -> message.get("id").equals(id))
                .findFirst()
                .orElseThrow(NotFoundException::new);
    }
           @PostMapping
    public Map<String,String> create (@RequestBody Map<String,String> message){
              message.put("id", String.valueOf(counter++));
              messages.add(message);
            return message;
           }
           @PutMapping("{id}")
    public Map<String,String> update (@PathVariable String id, @RequestBody Map<String,String> message) {
               Map<String, String> messageFromDb = getMessage(id);
               messageFromDb.putAll(message);
                messageFromDb.put("id",id);
            return messageFromDb;
           }
           @DeleteMapping ("{id}")
    public void delete (@PathVariable String id) {
               Map<String, String> message = getMessage(id);
               messages.remove(message);
           }
}

