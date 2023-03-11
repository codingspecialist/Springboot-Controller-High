package shop.mtcoding.filterandhandler.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import shop.mtcoding.filterandhandler.dto.JoinReqDto;
import shop.mtcoding.filterandhandler.dto.JoinRespDto;
import shop.mtcoding.filterandhandler.dto.ResponseDto;
import shop.mtcoding.filterandhandler.handler.ex.RestControllerException;
import shop.mtcoding.filterandhandler.handler.ex.ControllerException;
import shop.mtcoding.filterandhandler.util.Script;

@Controller
public class UserController {

    @GetMapping({"/", "/home"})
    public String home(){
        return "home";
    }

    @GetMapping("/loginForm")
    public String loginForm(){
        return "loginForm";
    }

    @PostMapping("/login/v1")
    public String loginV1(){
        return "redirect:/";
    }

    @PostMapping(value = "/login/v2", produces = "text/html; charset=utf-8")
    public @ResponseBody String loginV2(){
        return Script.href("/", "로그인성공");
    }

    @PostMapping("/login/v3")
    public @ResponseBody String loginV3(String username, String password){
        if(username == null || username.isEmpty()){
            return Script.back("username을 입력해주세요");
        }
        if(password == null || password.isEmpty()){
            return Script.back("password을 입력해주세요");
        }
        return Script.href("/", "로그인성공");
    }

    @GetMapping("/joinForm")
    public String joinForm(){
        return "joinForm";
    }

    @PostMapping("/join/v1")
    public ResponseEntity<?> joinV1(@RequestBody JoinReqDto joinReqDto){

        if(joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()){
            ResponseDto<?> responseDto = new ResponseDto<>("username이 없습니다.");
            return ResponseEntity.badRequest().body(responseDto);
        }
        if(joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()){
            ResponseDto<?> responseDto = new ResponseDto<>("password가 없습니다.");
            return ResponseEntity.badRequest().body(responseDto);
        }
        if(joinReqDto.getTel() == null || joinReqDto.getTel().isEmpty()){
            ResponseDto<?> responseDto = new ResponseDto<>("tel이 없습니다.");
            return ResponseEntity.badRequest().body(responseDto);
        }

        JoinRespDto joinRespDto = new JoinRespDto("cos", "0102222");
        ResponseDto<?> responseDto = new ResponseDto<>("회원가입 성공", joinRespDto);
        return ResponseEntity.ok().body(responseDto);
    }

    // 핸들러 사용
    @PostMapping("/join/v2")
    public ResponseEntity<?> joinV2(@RequestBody JoinReqDto joinReqDto){

        if(joinReqDto.getUsername() == null || joinReqDto.getUsername().isEmpty()){
            throw new RestControllerException("username을 입력해주세요");
        }
        if(joinReqDto.getPassword() == null || joinReqDto.getPassword().isEmpty()){
            throw new RestControllerException("password를 입력해주세요");
        }
        if(joinReqDto.getTel() == null || joinReqDto.getTel().isEmpty()){
            throw new RestControllerException("tel을 입력해주세요");
        }

        JoinRespDto joinRespDto = new JoinRespDto("cos", "0102222");
        ResponseDto<?> responseDto = new ResponseDto<>("회원가입 성공", joinRespDto);
        return ResponseEntity.ok().body(responseDto);
    }

    // 핸들러 사용
    @PostMapping("/login/v4")
    public @ResponseBody String loginV4(String username, String password){
        if(username == null || username.isEmpty()){
            throw new ControllerException("username을 입력해주세요");
        }
        if(password == null || password.isEmpty()){
            throw new ControllerException("password를 입력해주세요");
        }
        return Script.href("/", "로그인성공");
    }

}
