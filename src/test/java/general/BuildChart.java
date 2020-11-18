package general;

public class BuildChart 
{
    static int heightFt;
	static int heightInch;
    static int weight;
    
    public static boolean isStandard() 
    {
        boolean standardFlag = false;

        if(checkBuildChartsValidation(getCentimeter(heightFt, heightInch), weight) == false)
        {
            standardFlag = true;
        }else if(checkBuildChartsValidation(getCentimeter(heightFt, heightInch), weight) == true)
        {
            standardFlag = false;
        }

		return standardFlag;
    }
    
    public static Boolean isBuildChartKO()
    {
        boolean buildChartKOFlag = false;
        double heighCM = getCentimeter(heightFt, heightInch);
        if(checkBuildChart1KO(heighCM, weight))
        {
            buildChartKOFlag = true;
        }

        return buildChartKOFlag;
    }
    
    private static double getCentimeter(int feet, int inches) 
    {
        final double CONVERSION = 2.54;
        final int INCHES_PER_FOOT = 12;

        double totalInches;
        double totalCM = 0.0;

        try {
            totalInches = feet * INCHES_PER_FOOT + inches;
            totalCM = totalInches * CONVERSION;

        } catch (Exception nfe) {
            System.out.println("Exception @ Build chart validation ");
        }

        return Math.round(totalCM * 100.0) / 100.0;
    }

    private static boolean checkBuildChart1KO(double applicantHeight, int applicantWeight)
    {
        Boolean flagBuildChart1KO = false;

        if(applicantHeight >= getCentimeter(4, 10) && applicantHeight <= getCentimeter(6, 9))
        {
            // 4’10’ - 86 - 199	// 5’4” - 101 - 242	// 5’10” - 120 - 289 // 6’4” - 143 - 341
            // 4’11” - 88 - 205	// 5’5” - 104 - 249	// 5’11” - 125 - 298 // 6’5” - 146 - 350
            // 5’ - 90 - 212	// 5’6” - 106 - 257	// 6’ - 129 - 306	 // 6’6” - 149 - 359
            // 5’1” - 93 - 220	// 5’7” - 110 - 265	// 6’1” - 133 - 315	 // 6’7” - 153 - 368
            // 5’2” - 95 - 227	// 5’8” - 113 - 273	// 6’2” - 136 - 323	 // 6’8” - 157 - 378
            // 5’3” - 99 - 234	// 5’9” - 117 - 281	// 6’3” - 140 - 332	 // 6’9” - 160 - 387

            // Height is not qualified for Applicant will be KnockedOut

            if(applicantHeight == getCentimeter(4, 10)) {
                if(!(applicantWeight >= 86 && applicantWeight <= 199)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(4, 11)) {
                if(!(applicantWeight >= 88 && applicantWeight <= 205)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(5, 0)) {
                if(!(applicantWeight >= 90 && applicantWeight <= 212)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(5, 1)) {
                if(!(applicantWeight >= 93 && applicantWeight <= 220)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(5, 2)) {
                if(!(applicantWeight >= 95 && applicantWeight <= 227)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(5, 3)) {
                if(!(applicantWeight >= 99 && applicantWeight <= 234)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(5, 4)) {
                if(!(applicantWeight >= 101 && applicantWeight <= 242)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(5, 5)) {
                if(!(applicantWeight >= 104 && applicantWeight <= 249)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(5, 6)) {
                if(!(applicantWeight >= 106 && applicantWeight <= 257)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(5, 7)) {
                if(!(applicantWeight >= 110 && applicantWeight <= 265)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(5, 8)) {
                if(!(applicantWeight >= 113 && applicantWeight <= 273)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(5, 9)) {
                if(!(applicantWeight >= 117 && applicantWeight <= 281)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(5, 10)) {
                if(!(applicantWeight >= 120 && applicantWeight <= 289)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(5, 11)) {
                if(!(applicantWeight >= 125 && applicantWeight <= 298)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(6, 0)) {
                if(!(applicantWeight >= 129 && applicantWeight <= 306)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(6, 1)) {
                if(!(applicantWeight >= 133 && applicantWeight <= 315)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(6, 2)) {
                if(!(applicantWeight >= 136 && applicantWeight <= 323)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(6, 3)) {
                if(!(applicantWeight >= 140 && applicantWeight <= 332)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(6, 4)) {
                if(!(applicantWeight >= 143 && applicantWeight <= 341)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(6, 5)) {
                if(!(applicantWeight >= 146 && applicantWeight <= 350)) {
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(6, 6)) {
                if(!(applicantWeight >= 149 && applicantWeight <= 359)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(6, 7)) {
                if(!(applicantWeight >= 153 && applicantWeight <= 368)){
                    flagBuildChart1KO = true;
                }
            }if(applicantHeight == getCentimeter(6, 8)) {
                if(!(applicantWeight >= 157 && applicantWeight <= 378)) {
                    flagBuildChart1KO = true;
                }
            }else if(applicantHeight == getCentimeter(6, 9)) {
                if(!(applicantWeight >= 160 && applicantWeight <= 387)){
                    flagBuildChart1KO = true;
                }
            }

        }else{
            flagBuildChart1KO = true;
        }

        return flagBuildChart1KO;

    }

    private static boolean checkBuildChartsValidation(double applicantHeight, int applicantWeight)
    {
        Boolean flagSuppAppQues = false;

        // 4’10’ - 86 - 199	// 5’4” - 101 - 242	// 5’10” - 120 - 289 // 6’4” - 143 - 341
        // 4’11” - 88 - 205	// 5’5” - 104 - 249	// 5’11” - 125 - 298 // 6’5” - 146 - 350
        // 5’ - 90 - 212	// 5’6” - 106 - 257	// 6’ - 129 - 306	 // 6’6” - 149 - 359
        // 5’1” - 93 - 220	// 5’7” - 110 - 265	// 6’1” - 133 - 315	 // 6’7” - 153 - 368
        // 5’2” - 95 - 227	// 5’8” - 113 - 273	// 6’2” - 136 - 323	 // 6’8” - 157 - 378
        // 5’3” - 99 - 234	// 5’9” - 117 - 281	// 6’3” - 140 - 332	 // 6’9” - 160 - 387

        // Height is not qualified for Applicant will be KnockedOut

        if(applicantHeight == getCentimeter(4, 10)) {
            if(applicantWeight >= 86 && applicantWeight <= 199) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(4, 11)) {
            if(applicantWeight >= 88 && applicantWeight <= 205){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(5, 0)) {
            if(applicantWeight >= 90 && applicantWeight <= 212) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(5, 1)) {
            if(applicantWeight >= 93 && applicantWeight <= 220){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(5, 2)) {
            if(applicantWeight >= 95 && applicantWeight <= 227) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(5, 3)) {
            if(applicantWeight >= 99 && applicantWeight <= 234){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(5, 4)) {
            if(applicantWeight >= 101 && applicantWeight <= 242) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(5, 5)) {
            if(applicantWeight >= 104 && applicantWeight <= 249){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(5, 6)) {
            if(applicantWeight >= 106 && applicantWeight <= 257) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(5, 7)) {
            if(applicantWeight >= 110 && applicantWeight <= 265){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(5, 8)) {
            if(applicantWeight >= 113 && applicantWeight <= 273) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(5, 9)) {
            if(applicantWeight >= 117 && applicantWeight <= 281){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(5, 10)) {
            if(applicantWeight >= 120 && applicantWeight <= 289) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(5, 11)) {
            if(applicantWeight >= 125 && applicantWeight <= 298){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(6, 0)) {
            if(applicantWeight >= 129 && applicantWeight <= 306) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(6, 1)) {
            if(applicantWeight >= 133 && applicantWeight <= 315){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(6, 2)) {
            if(applicantWeight >= 136 && applicantWeight <= 323) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(6, 3)) {
            if(applicantWeight >= 140 && applicantWeight <= 332){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(6, 4)) {
            if(applicantWeight >= 143 && applicantWeight <= 341) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(6, 5)) {
            if(applicantWeight >= 146 && applicantWeight <= 350){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(6, 6)) {
            if(applicantWeight >= 149 && applicantWeight <= 359) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(6, 7)) {
            if(applicantWeight >= 153 && applicantWeight <= 368){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }if(applicantHeight == getCentimeter(6, 8)) {
            if(applicantWeight >= 157 && applicantWeight <= 378) {
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }else if(applicantHeight == getCentimeter(6, 9)) {
            if(applicantWeight >= 160 && applicantWeight <= 387){
                flagSuppAppQues = checkPreferredBuildChart(applicantHeight, applicantWeight);
            }
        }

        return flagSuppAppQues;

    }

    private static boolean checkPreferredBuildChart(double applicantHeight, int applicantWeight)
    {
        Boolean flagSuppAppQues = false;

        // 4'8" - 88 - 144	// 5'4" - 107 - 188	 // 6' - 135 - 238
        // 4'9" - 90 - 149	// 5'5" - 110 - 194	 // 6'1" - 139 - 245
        // 4'10" - 92 - 154	// 5'6" - 112 - 200	 // 6'2" - 142 - 251
        // 4'11" - 94 - 160	// 5'7" - 116 - 206	 // 6'3" - 146 - 258
        // 5' - 96 - 165	// 5'8" - 119 - 212	 // 6'4" - 149 - 265
        // 5'1" - 99 - 171	// 5'9" - 123 - 219	 // 6'5" - 152 - 272
        // 5'2" - 101 - 177	// 5'10" - 126 - 225 // 6'6" - 155 - 279
        // 5'3" - 105 - 182	// 5'11" - 131 - 231 // 6'7" - 158 - 287

        if(applicantHeight >= getCentimeter(4, 8) && applicantHeight <= getCentimeter(6, 7))
        {
            if(applicantHeight == getCentimeter(4, 8)) {
                if(applicantWeight >= 88 && applicantWeight <= 144) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(4, 9)) {
                if(applicantWeight >= 90 && applicantWeight <= 149) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(4, 10)) {
                if(applicantWeight >= 92 && applicantWeight <= 154) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(4, 11)) {
                if(applicantWeight >= 94 && applicantWeight <= 160){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(5, 0)) {
                if(applicantWeight >= 96 && applicantWeight <= 165) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(5, 1)) {
                if(applicantWeight >= 99 && applicantWeight <= 171){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(5, 2)) {
                if(applicantWeight >= 101 && applicantWeight <= 177) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(5, 3)) {
                if(applicantWeight >= 105 && applicantWeight <= 182){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(5, 4)) {
                if(applicantWeight >= 107 && applicantWeight <= 188) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(5, 5)) {
                if(applicantWeight >= 110 && applicantWeight <= 194){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(5, 6)) {
                if(applicantWeight >= 112 && applicantWeight <= 200) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(5, 7)) {
                if(applicantWeight >= 116 && applicantWeight <= 206){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(5, 8)) {
                if(applicantWeight >= 119 && applicantWeight <= 212) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(5, 9)) {
                if(applicantWeight >= 123 && applicantWeight <= 219){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(5, 10)) {
                if(applicantWeight >= 126 && applicantWeight <= 225) {
                    flagSuppAppQues = true;
                }
            }else if(applicantHeight == getCentimeter(5, 11)) {
                if(applicantWeight >= 131 && applicantWeight <= 231){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(6, 0)) {
                if(applicantWeight >= 135 && applicantWeight <= 238) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(6, 1)) {
                if(applicantWeight >= 139 && applicantWeight <= 245){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(6, 2)) {
                if(applicantWeight >= 142 && applicantWeight <= 251) {
                    flagSuppAppQues = true;
                }
            }else if(applicantHeight == getCentimeter(6, 3)) {
                if(applicantWeight >= 146 && applicantWeight <= 258){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(6, 4)) {
                if(applicantWeight >= 149 && applicantWeight <= 265) {
                    flagSuppAppQues = true;
                }
            }else if(applicantHeight == getCentimeter(6, 5)) {
                if(applicantWeight >= 152 && applicantWeight <= 272){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }if(applicantHeight == getCentimeter(6, 6)) {
                if(applicantWeight >= 155 && applicantWeight <= 279) {
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }else if(applicantHeight == getCentimeter(6, 7)) {
                if(applicantWeight >= 158 && applicantWeight <= 287){
                    flagSuppAppQues = true;
                }else{
                    flagSuppAppQues = false;
                }
            }

        }else{
            flagSuppAppQues = false;
        }

        return flagSuppAppQues;
    }
}
