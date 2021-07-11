package sd.sym.assignment.maxxton.service;

import sd.sym.assignment.maxxton.entity.CityPeriod;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class CityPeriodServiceData {

    public List<CityPeriod> getCityPeriodInputData() {

        List<CityPeriod> cityPeriodList = new ArrayList<>();

        cityPeriodList.add(getCityPeriod(1, "Pune", "01-JAN-2021", "15-JAN-2021", 10));
        cityPeriodList.add(getCityPeriod(2, "Mumbai", "01-JAN-2021", "15-FEB-2021", 20));
        cityPeriodList.add(getCityPeriod(3, "Delhi", "01-MAR-2021", "15-MAY-2021", 30));
        cityPeriodList.add(getCityPeriod(1, "Pune", "01-FEB-2021", "28-FEB-2021", 5));

        return cityPeriodList;
    }

    private CityPeriod getCityPeriod(int cityId, String name, String startDate, String endDate, int priority) {

        CityPeriod cityPeriod = new CityPeriod();
        cityPeriod.setCityId(cityId);
        cityPeriod.setName(name);
        cityPeriod.setStartDate(new Date(startDate));
        cityPeriod.setEndDate(new Date(endDate));
        cityPeriod.setPriority(priority);

        return cityPeriod;
    }
}
