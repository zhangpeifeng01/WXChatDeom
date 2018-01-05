package zpf.com.wxchatdeomapplication;

import android.support.test.uiautomator.UiAutomatorTestCase;
import android.support.test.uiautomator.UiObject;
import android.support.test.uiautomator.UiObjectNotFoundException;
import android.support.test.uiautomator.UiScrollable;
import android.support.test.uiautomator.UiSelector;
import android.util.Log;

/**
 * Created by pactera on 2018/1/2.
 */
public class WXChatDeom extends UiAutomatorTestCase {
    UiScrollable scroll;
    public void testNewDemo() throws UiObjectNotFoundException,InterruptedException{
        getUiDevice().pressHome();
        UiObject wx = new UiObject(new UiSelector().index(8));
        wx.clickAndWaitForNewWindow();
        UiObject addres=new UiObject(new UiSelector().text("通讯录"));
        addres.clickAndWaitForNewWindow();
        scroll = new UiScrollable(new  UiSelector().resourceId("com.tencent.mm:id/ih"));
        scroll.setAsVerticalList();
        while (true){
            sendMsg();
            if(scroll.scrollForward()){

            }else {
                break;
            }

        }

    }


    public void sendMsg() throws UiObjectNotFoundException {

        for (int i = 0; i < scroll.getChildCount(); i++) {
            Log.d("WXChatDeom",scroll.getChildCount()+""+i) ;
            UiObject item = scroll.getChild(new UiSelector().index(i));
            item.clickAndWaitForNewWindow();

            UiObject names = new UiObject(new UiSelector().resourceId("com.tencent.mm:id/p8"));
            if (names.exists()){
            String name = names.getText();
            Log.e("WXChatDeom", name);
                    UiObject anc= new UiObject(new UiSelector().resourceId("com.tencent.mm:id/anc"));
                    anc.click();
                    UiObject aaf=new UiObject(new UiSelector().resourceId("com.tencent.mm:id/aaf"));
                    aaf.setText(name+":周五啦");
                    UiObject aal=new UiObject(new UiSelector().resourceId("com.tencent.mm:id/aal"));
                    aal.click();
            }
            getUiDevice().pressBack();
                    UiObject addres1=new UiObject(new UiSelector().text("通讯录"));
                    addres1.clickAndWaitForNewWindow();
        }
    }
}
