package projects.bing.controller;

import org.apache.commons.io.FileUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;
import projects.bing.dto.JsonResult;
import projects.bing.service.MenuService;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.Date;

/**
 * Created by yang on 2017/3/8.
 */
@Controller
@RequestMapping(value = "/picture")
public class PictureController {
    @Autowired
    private MenuService menuService;
    private final int MAX_SIZE = 1024 * 1024 * 2;   //限制图片的最大值为2M
    private String[] extendNamesArray = {".jpg",".jpeg"};   //图片的扩展名数组，方面验证
    private String rootPath;                    //文件根路径
    private String imageNewPath;        //图片新路径（包含头像名以及扩展名）
    private String imageOldPath;        //图片在数据库中的原有路径（包含头像名以及扩展名）
    private String imageNames;          //图片的新名字（时间），时间精确到毫秒
    private String extendName ;         //图片的扩展名，进行扩展名验证，以达到对图片类型限制
    private String message;                 //用于返回图片的信息
    private String imageURL;                //用于返回图片存放的物理路径
    private MultipartFile image;

    @RequestMapping(value = "upload", method= RequestMethod.POST )
    @ResponseBody
    private JsonResult<String> upload(HttpServletRequest request){
        JsonResult jr = null;

        MultipartHttpServletRequest multipartRequest = (MultipartHttpServletRequest)request;
        //获取上传图片
        image = multipartRequest.getFile("imgFile");
        //获取上传图片的文件名
        String fileName = image.getOriginalFilename();
        System.out.println("OriginalFilename:"+fileName);
        //获取文件扩展名
        extendName = fileName.substring(fileName.lastIndexOf("."));
        //获取上传图片的大小
        int imageSize = (int) image.getSize();
        //验证图片的扩展名是否符合要求
        if((extendName.equals(extendNamesArray[0])||extendName.equals(extendNamesArray[1]))&&(imageSize<=MAX_SIZE)){
            rootPath = "D:/upload/menuPictures";
            File dir = new File(rootPath);
            if(!dir.exists()){
                dir.mkdirs();
            }
            System.out.println("rootPath:"+rootPath);
            imageNames = getUploadCurrentTime(); //重新命名上传图片名称
            System.out.println("imageNames:"+imageNames);
            imageNewPath = rootPath+ "/"+imageNames+extendName;
            System.out.println("imageNewPath:"+imageNewPath);

            if(imageSave(imageNewPath)){
                imageURL = imageNewPath;
                jr = new JsonResult<String>(true,imageURL);
            }else{
                jr= new JsonResult<String>(false,"保存失败");
            }
        }else{      //图像格式不符合或者头像的大小大于2M
            jr = new JsonResult<String>(false,"格式错误或图片大于2M");
        }
        return jr;
    }

    //获取当前时间
    private String getUploadCurrentTime() {
        return new Date().getTime()+"";
    }

    //对原有图片的新路径进行存储，存储后进行检查，存储成功返回true，失败则返回false
    private boolean imageSave(String imageNewPath){
        File uploadFile = new File(imageNewPath);
        try {
            FileCopyUtils.copy(image.getBytes(), uploadFile);
            FileUtils.copyInputStreamToFile(image.getInputStream(), new File(imageNewPath));
            return true;
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("上传图片失败...");
            return false;
        }
    }

    //输出图片
    @RequestMapping(value="getPicture",method = RequestMethod.GET)
    public void lookImage( HttpServletResponse response,String path ){
        response.setContentType("img/jpeg");
        response.setCharacterEncoding("utf-8");
        File picture = new File(path);
         if(path==null || !picture.exists()){
            path="D:/upload/default.jpg";
        }
        System.out.println(path + "path2");
        FileInputStream in = null;
        try {
            in = new FileInputStream(path);
            int len =0;
            byte buffer[] = new byte[1024];
            OutputStream out = response.getOutputStream();
            while((len = in.read(buffer))>0){
                out.write(buffer, 0, len);
            }
            in.close();
        } catch (FileNotFoundException e) {
            System.out.println(e.getMessage());
        }catch (IOException e){
            System.out.println(e.getMessage());
        }
    }
}
