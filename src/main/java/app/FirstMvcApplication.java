package app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Arrays;


/*
	login.html
		<form></form>
			username
			password
	/login - endpoint
		@PostMapping
		username, password
		if (!username.isBlank() && !password.isBlank()) {
			return "successLogin";
		} else {
			return "notLogin";
		}
	successLogin.html
		üdvözli a bejelentkezett felhasználót
	notLogin.html
		közli, hogy nem jelentkezett be
 */

















@SpringBootApplication
public class FirstMvcApplication {

	public static void main(String[] args) {
		SpringApplication.run(FirstMvcApplication.class, args);

		//System.out.println(Arrays.toString(new Fibonacci(10).collectSequence()));
	}

	private static void x() {
		LocalDate today = LocalDate.now();
		LocalDate date = findFirstMonday();

		int weekCounter = 0;


		while (date.isBefore(today) || date.isEqual(today)) {
			date = date.plusDays(7);
			weekCounter++;
		}

		System.out.println(weekCounter);
	}

	private static LocalDate findFirstMonday() {
		LocalDate firstMonday = LocalDate.of(2022, 1, 1);

		while (firstMonday.getDayOfWeek() != DayOfWeek.MONDAY) {
			firstMonday = firstMonday.plusDays(1);
		}

		return firstMonday;
	}

}
