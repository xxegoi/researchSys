package com.example.demo.controllers;

import com.example.demo.common.FailResult;
import com.example.demo.common.Page;
import com.example.demo.common.ReturnResult;
import com.example.demo.common.SucessResult;
import com.example.demo.pojo.User;
import com.example.demo.services.Impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/user")
public class userController {

    @Autowired
    UserServiceImpl userService=null;
    @Autowired
    SucessResult sucessResult=null;
    @Autowired
    FailResult failResult=null;

    @RequestMapping(value = "/getuser",method = RequestMethod.GET)
    public ReturnResult getUserById(int id){
        /**
         * create by: Mr.Deng
         * description:根据ID获取用户信息
         * create time: 9:32 2018/12/21
         *
           * @Param: id
         * @return com.example.demo.common.Result
         */
        Boolean flag=false;
        try{
            User u=userService.getUser(id);
            sucessResult.setData(u);
            flag=true;
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(failResult.getMessage().equals("")&&!flag){
                failResult.setMessage("未知错误");
            }

            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping("/getList")
    public ReturnResult getAll(@RequestBody(required = false)Page page){
        /**
         * create by: Mr.Deng
         * description:分页获取用户列表
         * create time: 9:33 2018/12/21
         *
           * @Param: page
         * @return com.example.demo.common.Result
         */
        Boolean flag=false;
        try{
            List<User> list=userService.getList(page);
            sucessResult.setData(list);
            flag=true;
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }
            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping(value = "/add",method = RequestMethod.POST)
    public ReturnResult insert(@RequestBody User user){
        Boolean flag=false;
        try{
            int i= userService.insert(user);

                sucessResult.setData(i);
                flag=true;
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }

            return flag?sucessResult:failResult;
        }

    }

    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public ReturnResult update(@RequestBody User user){
        Boolean flag=false;

        try{
            userService.update(user);
            flag=true;
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {

            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }

            return flag?sucessResult:failResult;
        }
    }

    @RequestMapping(value = "/delete",method = RequestMethod.GET)
    public ReturnResult delete(int id){
        Boolean flag=false;

        try{
            int i=userService.delete(id);
            if(i>0){
                flag=true;
            }
        }
        catch (Exception e){
            failResult.setMessage(e.getMessage());
        }
        finally {
            if(!flag&&failResult.getMessage()==null){
                failResult.setMessage("未知错误");
            }

            return flag?sucessResult:failResult;
        }
    }

}
