public String[] getPriceValueFromSearchResults(String stringToBeEvaluated) throws Exception {
        /**
         * search results page
         * --------------------------------------------
         * $9.99 at Target W McKinley Ave, Sunnyvale
         * ^\$(\d+[.]\d+)\s[a][t]\s(\w+)\s(.*)[,]\s(.*)
         * --------------------------------------------
         * 9.99
         * Target
         * W McKinley Ave
         * Sunnyvale
        */
        String[] arrayToBeReturned = new String[4];
        String line = stringToBeEvaluated;
        String pattern = uiMap.get("rPatternSearchResultsMain");
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(line);
        if (m.find()) {
            arrayToBeReturned[0] = m.group(1);
            arrayToBeReturned[1] = m.group(2);
            arrayToBeReturned[2] = m.group(3);
            arrayToBeReturned[3] = m.group(4);
        } else {
            throw new Exception("Error extracting price, retailer, address, and city from search results.");
        }
        return arrayToBeReturned; 
    }