package sd.sym.assignment.maxxton;

import sd.sym.assignment.maxxton.entity.CityPeriod;
import sd.sym.assignment.maxxton.service.CityPeriodService;
import sd.sym.assignment.maxxton.service.CityPeriodServiceData;

import java.util.List;

public class MaxxtonApplication {

	private CityPeriodService cityPeriodService = new CityPeriodService();

	public static void main(String[] args) {

		MaxxtonApplication maxxtonApplication = new MaxxtonApplication();
		CityPeriodServiceData cityPeriodServiceData = new CityPeriodServiceData();

		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet1());
		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet2());
		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet3());
		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet4());
		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet5());
		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet6());
		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet7());
		maxxtonApplication.runTestSet(cityPeriodServiceData.getCityPeriodInputDataSet8());
	}

	public void runTestSet(List<CityPeriod> cityPeriodList) {
		System.out.println("*******************************************************************************");
		System.out.println("Input :: cityPeriodList :: ");
		cityPeriodList.stream().forEach(System.out::println);

		System.out.println();

		List<CityPeriod> cpPrioritizedPeriodsList = cityPeriodService.getPrioritizedPeriods(cityPeriodList);
		System.out.println("Output :: cpPrioritizedPeriodsList :: ");
		cpPrioritizedPeriodsList.stream().forEach(System.out::println);
		System.out.println("*******************************************************************************");
		System.out.println();
	}
}
