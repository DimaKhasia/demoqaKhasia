package demoqaKhasia.pages.components;

import  java.lang.String;

import static com.codeborne.selenide.Selenide.$;

public class CalendarComponent {
    public void setDate(String day, String month, String year) {
        $(".react-datepicker__month-select").selectOption(month);
        $(".react-datepicker__year-select").selectOption(year);
      //  $(".react-datepicker__day--0" + day + ":not(.react-datepicker__day--outside-month)").click();

        String dayPickerLocator = String.format(".react-datepicker__day--0%s:not(.react-datepicker__day--outside-month)", day);
        $(dayPickerLocator).click();


    }
}
