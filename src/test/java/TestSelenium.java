import io.github.bonigarcia.seljup.SeleniumExtension;
import io.github.bonigarcia.seljup.SeleniumJupiter;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestFactory;
import org.junit.jupiter.api.extension.ExtendWith;
import org.openqa.selenium.Alert;
import org.openqa.selenium.By;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.is;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import org.openqa.selenium.ie.InternetExplorerDriver;
import retrofit2.http.Url;

@ExtendWith(SeleniumJupiter.class)


public class TestSelenium {

    @TestFactory

/// test đăng nhập

    // test với mật khẩu và tên đăng nhập đúng
    @Test
    public void testLoginSuccess(ChromeDriver chomeDriver) {
        chomeDriver.get("http://localhost:8080/login");
        WebElement tendangnhap = chomeDriver.findElement(By.id("iduser"));
        tendangnhap.sendKeys("thupq");

        WebElement matkhau = chomeDriver.findElement(By.id("password"));
        matkhau.sendKeys("123456");
        WebElement nhan = chomeDriver.findElement(By.id("nhan"));


        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        boolean k = false;
        nhan.click();
        if (!chomeDriver.getCurrentUrl().contains("http://localhost:8080/checkLog?iduser=thupq&passwords=123456#")) {
            k = true;
        }
        assertThat(k, is(true));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //test với tên đang nhập đúng và mật khẩu sai
    @Test
    public void testLoginError(ChromeDriver chomeDriver) {
        chomeDriver.get("http://localhost:8080/login");
        WebElement tendangnhap = chomeDriver.findElement(By.id("iduser"));
        tendangnhap.sendKeys("thupq");

        WebElement matkhau = chomeDriver.findElement(By.id("password"));
        matkhau.sendKeys("1234");
        WebElement nhan = chomeDriver.findElement(By.id("nhan"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nhan.click();
        WebElement thongbao = chomeDriver.findElement(By.id("thongbao"));
        assertThat(thongbao.getText(), containsString("Tài khoản hoặc mật khẩu sai!"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // test với tên đăng nhập sai và mật khẩu đúng
    @Test
    public void testLoginError2(ChromeDriver chomeDriver) {
        chomeDriver.get("http://localhost:8080/login");
        WebElement tendangnhap = chomeDriver.findElement(By.id("iduser23"));
        tendangnhap.sendKeys("thupq");

        WebElement matkhau = chomeDriver.findElement(By.id("password"));
        matkhau.sendKeys("123456");
        WebElement nhan = chomeDriver.findElement(By.id("nhan"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nhan.click();
        WebElement thongbao = chomeDriver.findElement(By.id("thongbao"));
        assertThat(thongbao.getText(), containsString("Tài khoản hoặc mật khẩu sai!"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    //test với mật khẩu và tên đăng nhập đề sai
    @Test
    public void testLoginError3(ChromeDriver chomeDriver) {
        chomeDriver.get("http://localhost:8080/login");
        WebElement tendangnhap = chomeDriver.findElement(By.id("iduser"));
        tendangnhap.sendKeys("thupq123");

        WebElement matkhau = chomeDriver.findElement(By.id("password"));
        matkhau.sendKeys("1234");
        WebElement nhan = chomeDriver.findElement(By.id("nhan"));

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nhan.click();
        WebElement thongbao = chomeDriver.findElement(By.id("thongbao"));
        assertThat(thongbao.getText(), containsString("Tài khoản hoặc mật khẩu sai!"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    // test với dữ liệu trống
    @Test
    public void testLoginError4(ChromeDriver chomeDriver) {
        chomeDriver.get("http://localhost:8080/login");
        WebElement nhan = chomeDriver.findElement(By.id("nhan"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        nhan.click();
        WebElement thongbao = chomeDriver.findElement(By.id("thongbao"));
        assertThat(thongbao.getText(), containsString("Tài khoản hoặc mật khẩu sai!"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }


    // Test Nhấn đăng xuất


    /// Test Tìm kiếm lịch học
    @Test
    public void TestTimKiemLichHocToanHocKy(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement timkiem = chromeDriver.findElement(By.id("timkiem"));
        timkiem.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestTimKiemLichHocTheoTenMonHoc(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement tenmonhoc = chromeDriver.findElement(By.id("tenmonhoc"));
        tenmonhoc.sendKeys("toan");
        WebElement timkiem = chromeDriver.findElement(By.id("timkiem"));
        timkiem.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Test
    public void TestXoaLichHoc(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement tenmonhoc = chromeDriver.findElement(By.id("tenmonhoc"));
        tenmonhoc.sendKeys("toan");
        WebElement timkiem = chromeDriver.findElement(By.id("timkiem"));
        timkiem.click();
        WebElement xoa = chromeDriver.findElement(By.id("xoa"));
        xoa.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        WebElement xoa2 = chromeDriver.findElement(By.id("delid"));
        xoa2.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


    // Test Thêm lịch học
    // test trường hợp thêm lịch không nhập dữ liệu
    @Test
    public void TestThemlichHoc(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement themlich = chromeDriver.findElement(By.id("themlich"));
        themlich.click();

        assertThat(chromeDriver.findElement(By.id("thongbaonhaplai")).getText(), containsString("Nhập đủ thông tin ở các trường bắt buộc"));


    }
    // test trường hợp thêm lịch có nhập đúng dữ liệu
    @Test
    public void TestThemlichHocSaiDl(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement themlich = chromeDriver.findElement(By.id("themlich"));
        themlich.click();
      chromeDriver.findElement(By.id("subject_id")).sendKeys("6");
        chromeDriver.findElement(By.id("lecturers_id")).click();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        String message=chromeDriver.switchTo().alert().getText();
        try {
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(message,containsString("Không tồn tại mã môn học. Bạn muốn thoát?"));

    }

    //Test thông báo thiếu dữ liệu tại trường hợp thêm lịch có đầy đủ dữ liệu
    @Test
    public void TestThemlichHocDayDu(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement themlich = chromeDriver.findElement(By.id("themlich"));
        themlich.click();
        chromeDriver.findElement(By.id("subject_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("lecturers_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("nhom")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tth")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("stc")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("malop")).sendKeys("20a");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("siso")).sendKeys("20");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("thu")).sendKeys("Monday");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tietbd")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("sotiet")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("namer")).sendKeys("703-A2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        assertThat(chromeDriver.findElement(By.id("thongbaonhaplai")).getText(), containsString("Nhập đủ thông tin ở các trường bắt buộc"));

    }

    //Test trường hợp thêm lịch sai định dạng sĩ số
    @Test
    public void TestThemlichHocDinhDang(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement themlich = chromeDriver.findElement(By.id("themlich"));
        themlich.click();
        chromeDriver.findElement(By.id("subject_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("lecturers_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("nhom")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tth")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("stc")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("malop")).sendKeys("20a");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("siso")).sendKeys("hahahaha");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("thu")).sendKeys("Monday");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tietbd")).sendKeys("5");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("sotiet")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("namer")).sendKeys("202-A3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("btnAdd")).click();
        String message=chromeDriver.switchTo().alert().getText();

        assertThat(message,containsString("Sĩ số phải là số!"));

    }

    //Test trường hợp thêm lịch thành công
    @Test
    public void TestThemlichHocThanhCong(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement themlich = chromeDriver.findElement(By.id("themlich"));
        themlich.click();
        chromeDriver.findElement(By.id("subject_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("lecturers_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("nhom")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tth")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("stc")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("malop")).sendKeys("20a");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("siso")).sendKeys("30");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("thu")).sendKeys("Monday");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tietbd")).sendKeys("5");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("sotiet")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("namer")).sendKeys("202-A3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("btnAdd")).click();
        String message=chromeDriver.switchTo().alert().getText();

        assertThat(message,containsString("Thêm thành công!"));

    }
    // Test nút Clear xóa bỏ dữ liệu
    @Test
    public void TestClearDulieu(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");


        WebElement themlich = chromeDriver.findElement(By.id("themlich"));
        themlich.click();


        chromeDriver.findElement(By.id("subject_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("lecturers_id")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("nhom")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tth")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("stc")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("malop")).sendKeys("20a");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("siso")).sendKeys("30");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("thu")).sendKeys("Monday");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("tietbd")).sendKeys("5");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("sotiet")).sendKeys("2");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("namer")).sendKeys("202-A3");
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        chromeDriver.findElement(By.id("btnReset")).click();
        assertThat( chromeDriver.findElement(By.id("subject_id")).getText(),containsString(null));
        assertThat( chromeDriver.findElement(By.id("lecturers_id")).getText(),containsString(null));
        assertThat(  chromeDriver.findElement(By.id("nhom")).getText(),containsString(null));
        assertThat( chromeDriver.findElement(By.id("malop")).getText(),containsString(null));
        assertThat( chromeDriver.findElement(By.id("siso")).getText(),containsString(null));



    }
    // Test xóa lịch học
    @Test
    public void TestXoaMonHoc(ChromeDriver chromeDriver) {
        chromeDriver.get("http://localhost:8080/lenlich");
        WebElement hocky = chromeDriver.findElement(By.id("semester"));
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        hocky.sendKeys("Học kỳ 1 năm học 2020-2021");
        WebElement timkiem = chromeDriver.findElement(By.id("timkiem"));
        timkiem.click();
        WebElement delete= chromeDriver.findElement(By.id("xoa"));
        delete.click();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }


}
