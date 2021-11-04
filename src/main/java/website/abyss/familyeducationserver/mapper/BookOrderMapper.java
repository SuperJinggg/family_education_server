package website.abyss.familyeducationserver.mapper;

import org.apache.ibatis.annotations.Mapper;
import website.abyss.familyeducationserver.entities.BookOrder;

import java.util.List;

@Mapper
public interface BookOrderMapper {

    void orderBook(BookOrder bookOrder);

    List<BookOrder> myOrderList(String parPhone);

    void cancelOrder(Integer id);
}