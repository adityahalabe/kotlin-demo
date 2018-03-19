package com.example.kotlindemo.controller

import com.example.kotlindemo.model.Article
import org.springframework.stereotype.Controller
import org.springframework.ui.Model
import org.springframework.web.bind.annotation.RequestMapping

@Controller
class HomeController {
    @RequestMapping(value = "/")
    fun default():  String{
        return "home"
    }

    @RequestMapping(value = "/home")
    fun home():  String{
        return "home"
    }

    @RequestMapping(value = "/login")
    fun login(): String {
        return "loginPage"
    }


    @RequestMapping(value = "/addArticle")
    fun addArticle(model : Model):  String{
        model.addAttribute("article", Article())
        return "addArticle"
    }

    @RequestMapping(value = "/search")
    fun searchArticle():  String{
        return "search"
    }

    @RequestMapping(value = "/delete")
    fun deleteArticle():  String{
        return "delete"
    }
}