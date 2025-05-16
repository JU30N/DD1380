
import java.util.*;

public class snowdepth {

    public static class Snowdepthrecord implements Comparable<Snowdepthrecord> {//only comparable snowdepht
        String date;
        String location;
        double depth;

        public Snowdepthrecord(String date, String location, double depth) {//one time use constant
            this.date = date;
            this.location = location;
            this.depth = depth;
        }

        public int getYear() {
            return Integer.parseInt(date.substring(0, 4));
        }

        @Override//override to make my own compareTo
        public int compareTo(Snowdepthrecord other) {
            int yes_no = Double.compare(other.depth, this.depth);
            if (yes_no != 0){
                return yes_no;//if not equal 
            }else{
            return this.location.compareTo(other.location);//if equal compare name
            }
        }

        @Override//override to make my own tostring thing
        public String toString() {
            return location + " " + String.format("%.1f", depth).replace(',','.');//no snowdepth1231#32432
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Map<Integer, List<Snowdepthrecord>> yearlydata = new HashMap<>();//dictionary

        while (scanner.hasNextLine()) {
            //2023-01-01 Stockholm 15.5
            //2023-01-02 Gothenburg 10.2
            //2023-01-03 Kiruna 15.5
            String line = scanner.nextLine().trim();
            if (line.isEmpty()) break;

            String[] parts = line.split(" ");//2023-01-01    Stockholm    15.5

            String date = parts[0];//2023-01-01 
            double depth = Double.parseDouble(parts[parts.length - 1]);//15.5

            StringBuilder locationBuilder = new StringBuilder();//build if location multiple words
            for (int i = 1; i < parts.length - 1; i++) {
                locationBuilder.append(parts[i]);
                if (i < parts.length - 2) {
                    locationBuilder.append(" ");
                }
            }
            String location = locationBuilder.toString();//location built Stockholm

            Snowdepthrecord record = new Snowdepthrecord(date, location, depth);//new record 2023-01-01 Stockholm 15.5
            int year = record.getYear();//2023

            if (!yearlydata.containsKey(year)) {//look if the year exists so 2023
                yearlydata.put(year, new ArrayList<>());//if not create a palce for 2023
            }
            yearlydata.get(year).add(record);//add record to the year if it exists

        }
        scanner.close();

        List<Integer> sortedYears = new ArrayList<>(yearlydata.keySet());
        //System.out.println(sortedYears);//2023 2024
        //System.out.println("\n");
        Collections.sort(sortedYears);//uses the compartTo in class sorts the years
        //System.out.println(sortedYears);
        //System.out.println("\n");

        for (int year : sortedYears) {
            List<Snowdepthrecord> records = yearlydata.get(year);
            Map<String, Snowdepthrecord> toprecord_location = new HashMap<>();

            // System.out.println(year);
            // System.out.println(records);

            Collections.sort(records); //sorts snow and location(byname )

            /* 
            System.out.println("this is year");
            System.out.println(year);
            System.out.println(records);
            System.out.println(toprecord_location);
            System.out.println("\n");
            System.out.println(year);
            System.out.println("\n");
            */

            for (Snowdepthrecord record : records) {
                String location = record.location;
                if (!toprecord_location.containsKey(location)) {//if location not in the map
                    toprecord_location.put(location, record);//put it in the map
                } else {
                    Snowdepthrecord existingRecord = toprecord_location.get(location);
                    if (record.depth > existingRecord.depth) {//if the new one is bigger
                        toprecord_location.put(location, record);//put it in the map
                    }
                }
            }
            //System.out.println(toprecord_location);
            List<Snowdepthrecord> sortedtoprecords = new ArrayList<>(toprecord_location.values());
            Collections.sort(sortedtoprecords); // sort the map
            //System.out.println("sorted records"+toprecord_location);
            //System.out.println(sortedtoprecords);





            System.out.println(year);
            for (int i = 0; i < Math.min(5, sortedtoprecords.size()); i++) {
                System.out.println(sortedtoprecords.get(i));
            }
        }
    }
}

//Du måste använda dig av en klass 
//som kan lagra snödjupsdata, och som implementerar gränsnittet Comparable.
//




//comparable 