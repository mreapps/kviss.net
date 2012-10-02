package com.mreapps.kvissnet.backend.server.dao.test;

import com.mreapps.kvissnet.backend.server.entity.Category;
import com.mreapps.kvissnet.backend.server.entity.enums.LanguageCode;
import com.mreapps.kvissnet.backend.server.factory.DaoFactory;
import org.junit.Test;

public class QuizDaoTest extends AbstractDaoTest
{
    @Test
    public void storeCategory()
    {
        Category category = new Category();
        category.setName(LanguageCode.ENGLISH, "Capitals");
        category.setName(LanguageCode.NORWEGIAN, "Hovedstader");

        DaoFactory.getCategoryDao().store(category);
    }
}
