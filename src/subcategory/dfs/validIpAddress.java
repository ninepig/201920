package subcategory.dfs;

/**
 * Created by yangw on 2019/7/5.
 */
public class validIpAddress {
    public String validIpAddress(String ip){
        if (isValidIpv4(ip)) return "IPv4";
        else if (isValidIPv6(ip)) return "IPv6";
        else return "Neither";
    }

    public boolean isValidIpv4(String ip){
        if (ip.length() < 7) return false;
        if (ip.charAt(0) == '.') return false;
        if (ip.charAt(ip.length()-1)=='.') return false;
        String[] tokens = ip.split("\\.");
        if (tokens.length !=4 ) return false;
        for (String token : tokens){
            if (!isValidIpv4Token(token)) return false;
        }
        return true;
    }

    private boolean isValidIpv4Token(String token) {
        if (token.startsWith("0")&&token.length()>1)return false;
        try{
            int parsedInt = Integer.parseInt(token);
            if (parsedInt < 0 || parsedInt> 255) return false;
            if (parsedInt == 0 && token.charAt(0) !='0') return false;
        }catch (NumberFormatException e){
            return false;
        }
        return true;
    }

    public boolean isValidIPv6(String ip) {
        if(ip.length()<15) return false;
        if(ip.charAt(0)==':') return false;
        if(ip.charAt(ip.length()-1)==':') return false;
        String[] tokens = ip.split(":");
        if(tokens.length!=8) return false;
        for(String token: tokens) {
            if(!isValidIPv6Token(token)) return false;
        }
        return true;
    }
    public boolean isValidIPv6Token(String token) {
        if(token.length()>4 || token.length()==0) return false;
        char[] chars = token.toCharArray();
        for(char c:chars) {
            boolean isDigit = c>=48 && c<=57;
            boolean isUppercaseAF = c>=65 && c<=70;
            boolean isLowerCaseAF = c>=97 && c<=102;
            if(!(isDigit || isUppercaseAF || isLowerCaseAF))
                return false;
        }
        return true;
    }



}
