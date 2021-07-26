package sd.sym.assignment.maxxton.service;

import sd.sym.assignment.maxxton.entity.CityPeriod;

import java.util.*;

public class CityPeriodService {

    public List<CityPeriod> getPrioritizedPeriods(List<CityPeriod> cityPeriodList) {
        return mapCityPeriodList(sortCityPeriodList(cityPeriodList));
    }

    //Based on StartDate & EndDate + Priority
    private List<CityPeriod> sortCityPeriodList(List<CityPeriod> cityPeriodList) {

        for(int i=0;i<cityPeriodList.size();i++){

            for(int j=i+1;j<cityPeriodList.size();j++){

                Date startDateI = cityPeriodList.get(i).getStartDate();
                Date startDateJ = cityPeriodList.get(j).getStartDate();

                Date endDateI = cityPeriodList.get(i).getEndDate();
                Date endDateJ = cityPeriodList.get(j).getEndDate();

                if(startDateI.compareTo(startDateJ) > 0) {
                    CityPeriod temp = cityPeriodList.get(i);
                    cityPeriodList.set(i, cityPeriodList.get(j));
                    cityPeriodList.set(j, temp);
                }
                if(overlap(startDateI, endDateI, startDateJ, endDateJ)) {
                    int priority1 = cityPeriodList.get(i).getPriority();
                    int priority2 = cityPeriodList.get(j).getPriority();
                    if (priority1 < priority2) {
                        CityPeriod temp = cityPeriodList.get(i);
                        cityPeriodList.set(i, cityPeriodList.get(j));
                        cityPeriodList.set(j, temp);
                    }
                }
            }
        }
        return cityPeriodList;
    }

    public boolean overlap(Date start1, Date end1, Date start2, Date end2){
        return start1.getTime() <= end2.getTime() && start2.getTime() <= end1.getTime();
    }
    public Date maxDate(Date a, Date b) {
        return a == null ? b : (b == null ? a : (a.before(b) ? b : a));
    }
    public Date leastDate(Date a, Date b) {
        return a == null ? b : (b == null ? a : (a.before(b) ? a : b));
    }
    private List<CityPeriod> mapCityPeriodList(List<CityPeriod> cityPeriodList) {

        cityPeriodList.stream().forEach(System.out::println);

        Date lastDate = null;
        int listMaxIndex = cityPeriodList.size() - 1;
        List<CityPeriod> returnCityPeriodList = new ArrayList<>();

        for (int i=0 ; i<listMaxIndex ; i++) {

            int j = i + 1;

            CityPeriod cityPeriodI = cityPeriodList.get(i);
            Date startDateI = cityPeriodI.getStartDate();
            Date endDateI = cityPeriodI.getEndDate();

            CityPeriod cityPeriodJ = cityPeriodList.get(j);
            Date startDateJ = cityPeriodJ.getStartDate();
            Date endDateJ = cityPeriodJ.getEndDate();

            Date newStartDate = null;
            if(null == lastDate && startDateJ.compareTo(startDateI) < 0 ){
                newStartDate = leastDate(startDateI, startDateJ);
                lastDate = leastDate(startDateI, endDateJ);
                cityPeriodJ.setStartDate(newStartDate);
                cityPeriodJ.setEndDate(lastDate);
                returnCityPeriodList.add(cityPeriodJ);

                cityPeriodI.setStartDate(lastDate);
                lastDate = maxDate(lastDate, endDateI);
                cityPeriodI.setEndDate(lastDate);
                returnCityPeriodList.add(cityPeriodI);

            }else if(null == lastDate || lastDate.compareTo(endDateI) < 0) {
                newStartDate = maxDate(startDateI, lastDate);
                if (overlap(startDateI, endDateI, startDateJ, endDateJ)) {
                    lastDate = maxDate(endDateJ, endDateI);
                } else {
                    lastDate = endDateI;
                }
                cityPeriodI.setStartDate(newStartDate);
                cityPeriodI.setEndDate(lastDate);
                returnCityPeriodList.add(cityPeriodI);
            }
        }

        //to process last index
        CityPeriod cityPeriodLast = cityPeriodList.get(listMaxIndex);
        Date startDateLast = cityPeriodLast.getStartDate();
        Date endDateLast = cityPeriodLast.getEndDate();
        Date newStartDate = maxDate(startDateLast, lastDate);
        cityPeriodLast.setStartDate(newStartDate);
        cityPeriodLast.setEndDate(endDateLast);
        returnCityPeriodList.add(cityPeriodLast);

        return returnCityPeriodList;
    }

    public Date getStartDate(CityPeriod cityPeriod1, CityPeriod cityPeriod2) {

        return null;
    }
}
