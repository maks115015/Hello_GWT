
package client.binders;


import com.googlecode.gwt.test.GwtModule;
import com.googlecode.gwt.test.GwtTest;
import org.junit.Test;

import static com.googlecode.gwt.test.assertions.GwtAssertions.assertThat;

@GwtModule("HelloGWT")
public class HelloViewTest extends GwtTest {

   @Test
   public void clickOnButtonShouldDisplayMessageInLabel() {
      LoginViewImpl loginView=new LoginViewImpl();
      assertThat(loginView.loginForm).isVisible();
   }


/*@Test
   public void deferredCommandShouldNotBeTriggerSynchronously() {
      // Arrange
      final StringBuilder sb = new StringBuilder();
      Scheduler.ScheduledCommand cmd = new ScheduledCommand() {

         public void execute() {
            sb.append("triggered!");
         }
      };

      // Assert the cmd is not yet triggered
      assertThat(sb.toString()).isEmpty();

      // Act
      Scheduler.get().scheduleDeferred(cmd);

      // simulate an event loop end
      getBrowserSimulator().fireLoopEnd();

      // Assert
      assertThat(sb.toString()).isEqualTo("triggered!");
   }

   @Test
   public void fillTextShouldEnableButton() {
      // Arrange
      SampleView view = new SampleView();
      // ensure the widgets state at init
      assertThat(view.label).isNotVisible();
      assertThat(view.button).isVisible().isNotEnabled();

      // Act
      Browser.fillText(view.textBox, "John Locke");

      // Assert
      GwtAssertions.assertThat(view.button).isVisible().isEnabled();
      assertThat(view.label).isNotVisible();
   }*/

}

