package pages;

public class Pages {
    LoginPage loginPage=new LoginPage();
    EditEventPage editEventPage=new EditEventPage();
    CreateEventPage createEventPage=new CreateEventPage();
    DashboardPage dashboardPage=new DashboardPage();

    public LoginPage loginPage() {
        if (loginPage == null) {
            loginPage = new LoginPage();
        }
        return loginPage;

    }

     public EditEventPage editEventPage() {
        if (editEventPage == null) {
            editEventPage = new EditEventPage();
        }
        return editEventPage;

    }

     public CreateEventPage createEventPage() {
        if (createEventPage == null) {
            createEventPage = new CreateEventPage();
        }
        return createEventPage;

    }

     public DashboardPage dashboardPage() {
        if (dashboardPage == null) {
            dashboardPage = new DashboardPage();
        }
        return dashboardPage;

    }



}
