package sd.sym.assignment.maxxton.service;

import sd.sym.assignment.maxxton.entity.CityPeriod;

import java.util.*;

public class CityPeriodService {

    public List<CityPeriod> getPrioritizedPeriods(List<CityPeriod> cityPeriodList) {

        return sortCityPeriodList(distinctCityPeriodList(cityPeriodList));
    }

    private List<CityPeriod> sortCityPeriodList(List<CityPeriod> cityPeriodList) {

        for(int i=0;i<cityPeriodList.size();i++){

            for(int j=i+1;j<cityPeriodList.size();j++){

                Date startDateI = cityPeriodList.get(i).getStartDate();
                Date startDateJ = cityPeriodList.get(j).getStartDate();

                if(startDateI.compareTo(startDateJ) > 0){
                    CityPeriod temp = cityPeriodList.get(i);
                    cityPeriodList.set(i, cityPeriodList.get(j));
                    cityPeriodList.set(j, temp);
                }
            }
        }

        return cityPeriodList;
    }

    private List<CityPeriod> distinctCityPeriodList(List<CityPeriod> cityPeriodList) {

        Map<Integer, CityPeriod> distinctMap = new HashMap<>();
        for(CityPeriod cityPeriod : cityPeriodList) {

            int cityId = cityPeriod.getCityId();

            if(distinctMap.containsKey(cityId)) {

                if(distinctMap.get(cityId).getStartDate().compareTo(cityPeriod.getStartDate()) < 0 ){
                    distinctMap.put(cityPeriod.getCityId(), cityPeriod);
                }
            }
            else {
                distinctMap.put(cityPeriod.getCityId(), cityPeriod);
            }
        }

        return new ArrayList<CityPeriod>(distinctMap.values());
    }
}
