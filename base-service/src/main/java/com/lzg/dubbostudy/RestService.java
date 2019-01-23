package com.lzg.dubbostudy;

import javax.validation.constraints.Min;

/**
 * @author 刘志钢
 */
public interface RestService {

    String hello();

    String getId(@Min(10) Long id);

    User getUser(User user);

    User getUserById(Long id);

}
