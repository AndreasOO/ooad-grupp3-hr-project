package Model;

import Database.*;
import View.*;
import View.SearchResultObserver;

import java.util.*;

public class HRModel {

    private Database employeeDatabase;
    private List<Employee> currentSearchResult;
    private List<Employee> positionSearchResult;
    private Employee selectedEmployee;

    private List<EmployeeDetailsObserver> detailsObservers;
    private List<SearchResultObserver> searchObservers;
    private List<FilterPositionObserver> positionSearchObservers;

    public HRModel() {
        employeeDatabase = new Database();

        currentSearchResult = new ArrayList<>();
        positionSearchResult = new ArrayList<>();

        detailsObservers = new ArrayList<>();
        searchObservers = new ArrayList<>();
        positionSearchObservers = new ArrayList<>();
    }

    public List<Employee> getCurrentSearchResult() {
        return currentSearchResult;
    }

    public Employee getSelectedEmployee() {
        return selectedEmployee;
    }

    public List<Employee> getCurrentFilteredSearch(){
        return positionSearchResult;
    }

    public void notifyDetailsObservers() {
        for(EmployeeDetailsObserver observer : detailsObservers) {
            observer.updateEmployeeDetails();
        }
    }

    public void notifySearchObservers() {
        for(SearchResultObserver observer : searchObservers) {
            observer.updateSearchResult();
        }
    }

    public void notifyPositionSearchObservers() {
        for(FilterPositionObserver observer : positionSearchObservers) {
            observer.updateFilterSearch();
        }
    }


    public void registerDetailsObserver(EmployeeDetailsObserver employeeDetailsObserver) {
        detailsObservers.add(employeeDetailsObserver);
    }

    public void registerSearchObserver(SearchResultObserver searchResultObserver) {
        searchObservers.add(searchResultObserver);
    }

    public void registerPositionSearchObserver(FilterPositionObserver filterPositionObserver) {
        positionSearchObservers.add(filterPositionObserver);
    }

    public void setSearchResultByName(String name) {
        currentSearchResult = employeeDatabase.searchByName(name);
        notifySearchObservers();
    }

    public void setSearchResultById(long id) {
        currentSearchResult = employeeDatabase.searchByID(id);
        notifySearchObservers();
    }

    public void setSearchResultByEmail(String email){
        currentSearchResult = employeeDatabase.searchByEmail(email);
        notifySearchObservers();
    }

    public void setSearchResultByPhone(String phone){
        currentSearchResult = employeeDatabase.searchByPhoneNumber(phone);
        notifySearchObservers();
    }

    public void filterSearchResultByPosition(String position) {
        List<Employee> filteredList = new ArrayList<>();
        if (position.equals("None")) {
            positionSearchResult.clear();
            positionSearchResult.addAll(currentSearchResult);
        } else {
            for (Employee employee : currentSearchResult) {
                if (employee.getPosition().getPosition().equals(position)) {
                    filteredList.add(employee);
                }
            }
            positionSearchResult.clear();
            positionSearchResult.addAll(filteredList);
        }
        notifyPositionSearchObservers();
    }
    public void selectEmployee(long id) {
        List<Employee> foundEmployees = employeeDatabase.searchByID(id);
        if (foundEmployees != null) {
            selectedEmployee = foundEmployees.getFirst();
        }
        notifyDetailsObservers();
    }
}
