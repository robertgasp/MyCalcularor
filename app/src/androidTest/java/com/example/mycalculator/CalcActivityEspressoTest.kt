package com.example.mycalculator

import android.widget.Button
import android.widget.TextView
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.example.mycalculator.ui.CalcActivity
import junit.framework.TestCase
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CalcActivityEspressoTest {

    private lateinit var scenario : ActivityScenario<CalcActivity>

    @Before
    fun setup(){
        scenario = ActivityScenario.launch(CalcActivity::class.java)
    }

    @Test
    fun calcActivity_isNotNull(){
        scenario.onActivity {
            TestCase.assertNotNull(it)
        }
    }

    @Test
    fun expression_isNotNull(){
        scenario.onActivity {
            val expression = it.findViewById<TextView>(R.id.expression)
            TestCase.assertNotNull(expression)
        }
    }

    @Test
    fun digits_isNotNull(){
        scenario.onActivity {
            val digits = it.findViewById<TextView>(R.id.digits)
            TestCase.assertNotNull(digits)
        }
    }

    @Test
    fun button_isNotNull(){
        scenario.onActivity {
            val button1 = it.findViewById<Button>(R.id.btn_1)
            TestCase.assertNotNull(button1)
        }
    }

    @Test
    fun buttonText_isNotNull(){
        Espresso.onView(ViewMatchers.withId(R.id.btn_1))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }

    @Test
    fun check_digits_on_Display(){
        Espresso.onView(ViewMatchers.withId(R.id.btn_1))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.digits))
            .check(ViewAssertions.matches(ViewMatchers.withText("1")))
    }

    @Test
    fun checkExpression_and_digits(){
        Espresso.onView(ViewMatchers.withId(R.id.btn_1))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn_plus))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn_1))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.btn_equal))
            .perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.expression))
            .check(ViewAssertions.matches(ViewMatchers.withText("1+1.0=")))
        Espresso.onView(ViewMatchers.withText(R.id.digits))
            .check(ViewAssertions.matches(ViewMatchers.withText("2")))
    }


    @After
    fun close(){
        scenario.close()
    }
}