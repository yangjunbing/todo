package projects.bing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import projects.bing.dto.JsonResult;
import projects.bing.entity.Article;
import projects.bing.entity.Theme;
import projects.bing.service.ArticleService;
import projects.bing.service.ThemeService;
import projects.bing.utils.IdGen;

import java.util.List;

@Controller
@RequestMapping(value = "/article")
public class ArticleController {

    @Autowired
    private ThemeService themeService;

    @Autowired
    private ArticleService articleService;

    @RequestMapping(value = "list")
    public String list (Model model,String themeid){
        Theme theme = themeService.getOne(themeid);
        List<Article> articleList =  articleService.getByTheme(themeid);
        model.addAttribute("theme",theme);
        model.addAttribute("articleList",articleList);
        return "page_article";
    }

    @RequestMapping(value = "edit")
    public String edit (Model model,String id,String themeid){
        Theme theme = themeService.getOne(themeid);
        List<Article> articleList =  articleService.getByTheme(themeid);
        Article article = new Article();
        if(id != null && !"".equals(id)){
             article = articleService.getOne(id);
        }
        model.addAttribute("theme",theme);
        model.addAttribute("article",article);
        return "edit_article";
    }

    //新增或保存
    @RequestMapping(value="addOrEdit" , method = RequestMethod.POST,
            produces = "application/json;charset=utf-8")
    @ResponseBody
    public JsonResult saveOrEdit(Article article){
        JsonResult jr ;
        String message = null;
        boolean flag = false;
        if("".equals(article.getId())){  //新增
            article.setId(IdGen.getUUID32());
            flag = articleService.add(article) > 0  ? true : false;
            message = "添加成功↖(^ω^)↗";
        }else{
            flag = articleService.update(article) > 0 ? true : false;
            message = "修改成功↖(^ω^)↗";
        }
        if(flag == false){
            message = "系统异常，请稍后重试！";
        }
        jr = new JsonResult(flag,message);
        return jr;
    }

}
