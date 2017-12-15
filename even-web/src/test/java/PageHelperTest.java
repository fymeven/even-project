import com.even.common.util.MyPageInfo;
import com.even.common.util.PageModel;
import com.even.io.sysMenu.response.SysMenuResponse;
import com.even.service.ISysMenuService;
import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.transaction.TransactionConfiguration;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;

/**
 * Created by Administrator on 2017/9/30 0030.
 */
@RunWith(SpringJUnit4ClassRunner.class)
//@WebAppConfiguration
@ContextConfiguration("classpath:spring/spring-application.xml")
//无论成功与否都进行事务回滚
@TransactionConfiguration(defaultRollback = false)
@Transactional
public class PageHelperTest {
    private static final Logger logger= LogManager.getLogger(PageHelperTest.class.getName());

    @Resource
    private ISysMenuService sysMenuService;

    @Test
    public void testSelectAll() {
        PageModel pageModel=new PageModel();
        pageModel.setPage(1);
        pageModel.setRows(3);
        pageModel.setSidx("update_time");
        pageModel.setSord("DESC");
        try {
            MyPageInfo<SysMenuResponse> pageInfo = sysMenuService.selectChildrenMenus(1L, pageModel);
            System.err.println("err");
            System.out.println(pageInfo);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testSelectAllRoles() {
        try {

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
