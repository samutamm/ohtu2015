import ohtu.*
import ohtu.authentication.*
import org.openqa.selenium.*
import org.openqa.selenium.htmlunit.HtmlUnitDriver;

description """A new user account can be created
              if a proper unused username
              and a proper password are given"""

scenario "creation succesfull with correct username and password", {
    given 'command new user is selected'

    when 'a valid username and password are entered'

    then 'new user is registered to system'
}
