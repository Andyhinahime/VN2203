package cn.tedu.jsdvn2203.csmall.server;

import cn.tedu.jsdvn2203.csmall.server.controller.AlbumController;
import cn.tedu.jsdvn2203.csmall.server.controller.BrandController;
import cn.tedu.jsdvn2203.csmall.server.controller.CategoryController;
import cn.tedu.jsdvn2203.csmall.server.controller.PictureController;
import cn.tedu.jsdvn2203.csmall.server.repo.IAlbumRepository;
import cn.tedu.jsdvn2203.csmall.server.repo.impl.AlbumRepositoryImpl;
import cn.tedu.jsdvn2203.csmall.server.repo.impl.BrandRepositoryImpl;
import cn.tedu.jsdvn2203.csmall.server.repo.IBrandRepository;
import cn.tedu.jsdvn2203.csmall.server.repo.ICategoryRepository;
import cn.tedu.jsdvn2203.csmall.server.service.IAlbumService;
import cn.tedu.jsdvn2203.csmall.server.service.impl.AlbumServiceImpl;
import cn.tedu.jsdvn2203.csmall.server.service.impl.BrandServiceImpl;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.context.support.GenericWebApplicationContext;

import java.util.Date;

@SpringBootTest
class Jsdvn2203CsmallServerApplicationTests {

    @Autowired
    public ApplicationContext ac; //父級類型裝配 Spring 容器
    //  public AnnotationConfigApplicationContext ac; //Spring容器 spring-boot-starter
    //  public GenericWebApplicationContext ac; // spring-boot-starter-web
    @Autowired
    public ICategoryRepository categoryRepository; //有實現接口時創建接口對象
    //public CategoryRepositoryImpl categoryRepository;


    @Test
    void contextLoads() {
        CategoryController categoryController = ac.getBean(CategoryController.class);
        System.out.println(categoryController);

        Date date = ac.getBean(Date.class);
        System.out.println(date);
        AlbumController albumController = ac.getBean(AlbumController.class);
        System.out.println(albumController);
        BrandController brandController = ac.getBean(BrandController.class);
        System.out.println(brandController);
        PictureController pictureController = ac.getBean(PictureController.class);
        System.out.println(pictureController);
        System.out.println(categoryController);
    }

    @Autowired
    CategoryController categoryController;
    @Autowired
    Date date;
    @Autowired
    AlbumController albumController;
    @Autowired
    BrandController brandController;

    @Test
    public void testAutowired() {
        System.out.println(categoryController);
        System.out.println(date);
        System.out.println(albumController);
        System.out.println(brandController);
        System.out.println(categoryRepository);
    }

    @Autowired
    BrandServiceImpl brandService;
    @Autowired
    BrandRepositoryImpl brandRepository1;
    @Autowired
    IBrandRepository brandRepository2;

 /*   @Test
    public void testBrandAutowired() {
        //Spring 創建對象時 對象是唯一性 所以下面代碼返回的地址都會相同
        System.out.println("通過Service獲取:" + brandService.brandRepository);
        System.out.println("通過實現類獲取:" + brandRepository1);
        System.out.println("通過接口獲取:" + brandRepository2);
    }
*/
    @Autowired
    AlbumServiceImpl albumService;
    @Autowired
    AlbumRepositoryImpl albumRepository1;
    @Autowired
    IAlbumRepository albumService2;

   /* @Test
    public void testAlbumAutowired() {
        //Spring 創建對象時 對象是唯一性 所以下面代碼返回的地址都會相同
        System.out.println("通過Service獲取:" + albumService.albumRepository);
        System.out.println("通過實現類獲取:" + albumRepository1);
        System.out.println("通過接口獲取:" + albumService2);
    }*/



}
