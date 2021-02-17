@RequestMapping(value = "/spring/usersolvdata", produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public class resUserSolvData {
		
	//1번 방법
			/*public JSONArray resUserData(String id, String solvedList[]) { // solvedList[0] = 1001, solvedList[1] = 1002, .... 와 동일한 형식 
			
				JSONObject jsonValueid=new JSONObject();
				JSONObject jsonValuedata=new JSONObject();
				JSONArray jsonArray=new JSONArray();
				
				
				jsonValueid.put("id", id);
				jsonValuedata.put("SolvedList", solvedList);
				jsonArray.put(jsonValueid);
				jsonArray.put(jsonValuedata);				
				
				return jsonArray;*/
				
	//2번 방법			
			public JSONArray resUserData(String id, String solvedList) {
				
				String[] solvedListArray = motherCode.substring(1, solvedList.length()-1).split(",");// solvedList=[1001,1002,1003, ....., 9999] 형식의 String
				JSONObject jsonValueid=new JSONObject();
				JSONObject jsonValuedata=new JSONObject();
				JSONArray jsonArray=new JSONArray();
				
				jsonValueid.put("id", id);
				jsonValuedata.put("SolvedList", solvedListArray);
				jsonArray.put(jsonValueid);
				jsonArray.put(jsonValuedata);	
				
				return jsonArray;
			
		}
	}