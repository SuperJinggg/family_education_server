package website.abyss.familyeducationserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("website.abyss.familyeducationserver.mapper")
public class FamilyEducationServerApplication {
    public static void main(String[] args) {
        SpringApplication.run(FamilyEducationServerApplication.class, args);
    }

}
