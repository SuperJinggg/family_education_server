package website.abyss.familyeducationserver.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import website.abyss.familyeducationserver.entities.BookOrder;
import website.abyss.familyeducationserver.entities.Parent;
import website.abyss.familyeducationserver.mapper.BookOrderMapper;

import java.util.List;

@Service
@Transactional
public class BookOrderService {

    private BookOrderMapper bookOrderMapper;

    @Autowired
    public BookOrderService(BookOrderMapper bookOrderMapper) {
        this.bookOrderMapper = bookOrderMapper;
    }

    public void orderBook(BookOrder bookOrder) {
        bookOrderMapper.orderBook(bookOrder);
    }

    public List<BookOrder> myOrderList(Parent parent) {
        return bookOrderMapper.myOrderList(parent.getParPhone());
    }

    public void cancelOrder(BookOrder bookOrder) {
        bookOrderMapper.cancelOrder(bookOrder.getId());
    }
}
