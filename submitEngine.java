@RequestMapping(value = "/spring/submitEngine", produces = "application/json; charset=utf8", method = RequestMethod.POST)
	public ResponseEntity<String> submitEngine(String SubNum, String Pnum, int tccnt, Object Pcode) {
		// make Body
		MultiValueMap<String, Object> params = new LinkedMultiValueMap<>();
		System.out.println(Pcode);
		params.add("SubNum", SubNum);
		params.add("Pnum", Pnum);
		params.add("tc-cnt", tccnt);
		params.add("Pcode", Pcode);
		System.out.println(params.toString());
		
		String tempurl;
		
		/*외부에 추가해야 할 코드
		 * static Queue<String> serverqueue=new LinkedList<String>();
		static Queue<String> clientqSubNum=new LinkedList<String>();
		static Queue<String> clientqPnum=new LinkedList<String>();
		static Queue<Object> clientqPcode=new LinkedList<Object>();
		
		
		serverqueue.add("1");
		serverqueue.add("2");
		serverqueue.add("3");
		serverqueue.add("4");
		serverqueue.add("5");
		serverqueue.add("6");*/
		
		if(serverqueue.isEmpty()==true)
		{
			clientqSubNum.add(SubNum);
			clientqPnum.add(Pnum);
			clientqPcode.add(Pcode);
		}
		else {
			
			if(clientqSubNum.isEmpty()==true)
			{
				params.add("SubNum", "[제출 번호]");
				params.add("Pnum", "[문제 번호]");
				params.add("Pcode", "[제출 코드]");
			}
			else {
				params.add("SubNum", clientqSubNum.poll());
				params.add("Pnum", clientqPnum.poll());
				params.add("Pcode", clientqPcode.poll());
			}
			tempurl = eurl+"/judger-engine/"+serverqueue.poll();
			
			serverqueue.add(tempurl);
			
		}
		
		
		// make Entity
		HttpEntity<MultiValueMap<String, String>> entity = new HttpEntity(params, headers); 
		RestTemplate rt = new RestTemplate();
		
		
		/*String url = eurl+"/judger-engine/1";*/
		return rt.exchange(tempurl, HttpMethod.POST, entity, String.class);
		
	}