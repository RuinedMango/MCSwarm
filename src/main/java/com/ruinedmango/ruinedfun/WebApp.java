package com.ruinedmango.ruinedfun;

import java.io.IOException;
import java.util.Map;

import fi.iki.elonen.NanoHTTPD;

public class WebApp extends NanoHTTPD{

	public WebApp() throws IOException {
		super(8080);
		start(NanoHTTPD.SOCKET_READ_TIMEOUT, false);
		System.out.print("\\nRunning! Point your browers to http://localhost:8080/ \\n");
		// TODO Auto-generated constructor stub
	}
	
	@Override
	public Response serve(IHTTPSession session) {
		String msg = "<html><body><h1>Hello Server</h1>\n";
		Map<String, String> parms = session.getParms();
		if(parms.get("username") == null) {
			msg += "<form action='?' method='get'>\n  <p>Your name: <input type='text' name='username'></p>\n" + "</form>\n";
		}else {
			msg += "<p>Hello, " + parms.get("username") + "!</p>";
		}
		return newFixedLengthResponse(msg + "</body></html>\n");
	}

}
