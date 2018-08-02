package youtubeSerilisation;

/**
 * Created by Iryna_Bartnytska on 8/2/2018.
 */
public class PageInfo {

    private int totalResults;
    private String resultsPerPage;

    public int getTotalResults() {
        return totalResults;
    }

    public void setTotalResults(int totalResults) {
        this.totalResults = totalResults;
    }

    public String getResultsPerPage() {
        return resultsPerPage;
    }

    public void setResultsPerPage(String resultsPerPage) {
        this.resultsPerPage = resultsPerPage;
    }
}
