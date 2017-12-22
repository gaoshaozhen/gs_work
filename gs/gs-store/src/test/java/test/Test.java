package test;

import com.fasterxml.jackson.core.type.TypeReference;
import com.gs.sdk.web.HttpGate;
import com.gs.store.dto.SysCustDTO;

public class Test {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		HttpGate.post("/sys/cust/add", null, new TypeReference<SysCustDTO>(){});
	}

}
