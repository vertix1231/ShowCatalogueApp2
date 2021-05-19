package com.dicoding.bangkit.android.jetpack.showcatalogueapp.ui.activityui

import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.Espresso
import androidx.test.espresso.IdlingRegistry
import androidx.test.espresso.action.ViewActions
import androidx.test.espresso.assertion.ViewAssertions
import androidx.test.espresso.contrib.RecyclerViewActions
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.internal.runner.junit4.AndroidJUnit4ClassRunner
import androidx.test.rule.ActivityTestRule
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.R
import com.dicoding.bangkit.android.jetpack.showcatalogueapp.utils.EspressoIdlingResource
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith


@Suppress("DEPRECATION")
@RunWith(AndroidJUnit4ClassRunner::class)
class MainActivityTest {

    @get:Rule
    var activityRule = ActivityTestRule(MainActivity::class.java)

    @Before
    fun setUp() {
        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
    }

    @After
    fun tearDown() {
        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
    }

    //framgent TVSHOW OK LAGI TEST
    @Test
    fun loadCoursesTvshow() {
        Espresso.onView(ViewMatchers.withId(R.id.nav_tvshow)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_tvshow)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.rv_tvshow)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))

        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_name))
//            .check(ViewAssertions.matches(ViewMatchers.withText(dummyCourseTvshow[0].name)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_desc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_desc))
//            .check(ViewAssertions.matches(ViewMatchers.withText(dummyCourseTvshow[0].desc)))
        Espresso.pressBack()

    }

    //framgent MOVIE OK LAGI TEST
    @Test
    fun loadCoursesMovie() {
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie)).check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
        Espresso.onView(ViewMatchers.withId(R.id.nav_movie)).perform(ViewActions.click())
        Espresso.onView(ViewMatchers.withId(R.id.rv_movie)).perform(
            RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(0,
                ViewActions.click()
            ))

        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_name))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_name))
//            .check(ViewAssertions.matches(ViewMatchers.withText(dummyCourseMovie[0].name)))
        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_desc))
            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(ViewMatchers.withId(R.id.tv_detail_desc))
//            .check(ViewAssertions.matches(ViewMatchers.withText(dummyCourseMovie[0].desc)))
        Espresso.pressBack()
    }

}


//class MainActivityTest {
//    @get:Rule
//    var activityRule = ActivityTestRule(MainActivity::class.java)
//
//    @Before
//    fun setUp() {
//        IdlingRegistry.getInstance().register(EspressoIdlingResource.espressoTestIdlingResource)
//    }
//
//    @After
//    fun tearDown() {
//        IdlingRegistry.getInstance().unregister(EspressoIdlingResource.espressoTestIdlingResource)
//    }
//
//    @Test
//    fun loadMovieAndTvShow() {
//        Espresso.onView(withId(R.id.rv_movie))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.rv_movie))
//            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
//
//        Espresso.onView(withText(R.string.tab_title_tvshow)).perform(ViewActions.click())
//        Espresso.onView(withId(R.id.rv_tvshow))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.rv_tvshow))
//            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
//
//        Espresso.onView(withText(R.string.tab_title_movie)).perform(ViewActions.click())
//    }
//
//    @Test
//    fun detailMovie() {
//        Espresso.onView(withId(R.id.rv_movie))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.rv_movie))
//            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
//        Espresso.onView(withId(R.id.rv_movie))
//            .perform(
//                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5,
//                    ViewActions.click()
//                ))
//
//        Espresso.onView(withId(R.id.img_detail_hightlight))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.img_detail_poster))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.tv_detail_name))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.tv_detail_desc))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//
//        Espresso.pressBack()
//    }
//
//    @Test
//    fun detailTvShow() {
//        Espresso.onView(withText(R.string.tab_title_tvshow)).perform(ViewActions.click())
//        Espresso.onView(withId(R.id.rv_tvshow))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.rv_tvshow))
//            .perform(RecyclerViewActions.scrollToPosition<RecyclerView.ViewHolder>(5))
//        Espresso.onView(withId(R.id.rv_tvshow))
//            .perform(
//                RecyclerViewActions.actionOnItemAtPosition<RecyclerView.ViewHolder>(5,
//                    ViewActions.click()
//                ))
//
//        Espresso.onView(withId(R.id.img_detail_hightlight))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.img_detail_poster))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.tv_detail_name))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//        Espresso.onView(withId(R.id.tv_detail_desc))
//            .check(ViewAssertions.matches(ViewMatchers.isDisplayed()))
//
//        Espresso.pressBack()
//    }
//}