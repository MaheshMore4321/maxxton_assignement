package sd.sym.assignment.maxxton;

import sd.sym.assignment.maxxton.entity.CityPeriod;
import sd.sym.assignment.maxxton.service.CityPeriodService;
import sd.sym.assignment.maxxton.service.CityPeriodServiceData;

import java.util.List;

public class MaxxtonApplication {

	public static void main(String[] args) {

		CityPeriodServiceData cityPeriodServiceData = new CityPeriodServiceData();
		CityPeriodService cityPeriodService = new CityPeriodService();

		List<CityPeriod> cityPeriodList = cityPeriodServiceData.getCityPeriodInputData();
		System.out.println("Input :: cityPeriodList :: ");
		cityPeriodList.stream().forEach(System.out::println);

		System.out.println();

		List<CityPeriod> cpPrioritizedPeriodsList = cityPeriodService.getPrioritizedPeriods(cityPeriodList);
		System.out.println("Output :: cpPrioritizedPeriodsList :: ");
		cpPrioritizedPeriodsList.stream().forEach(System.out::println);
	}
}
