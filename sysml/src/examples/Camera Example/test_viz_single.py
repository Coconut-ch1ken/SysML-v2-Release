import jupyter_client

km = jupyter_client.KernelManager(kernel_name='sysml')
km.start_kernel()
kc = km.client()
kc.start_channels()
kc.wait_for_ready(timeout=10)

def run_cell(code):
    kc.execute(code)
    replies = []
    while True:
        msg = kc.get_iopub_msg(timeout=10)
        if msg['msg_type'] == 'status' and msg['content']['execution_state'] == 'idle':
            break
        if msg['msg_type'] in ('execute_result', 'display_data', 'stream', 'error'):
            replies.append(msg)
    return replies

print("Testing merged cell:")
res = run_cell("""package PictureTaking {
	part def Exposure;
	
	action def Focus { out xrsl: Exposure; }
	action def Shoot { in xsf: Exposure; }	
		
	action takePicture {		
		action focus: Focus[1];
		flow of Exposure from focus.xrsl to shoot.xsf;
		action shoot: Shoot[1];
	}
}

part def Camera {
	private import PictureTaking::*;
	
	perform action takePicture[*] :> PictureTaking::takePicture;
	
	part focusingSubsystem {
		perform takePicture.focus;
	}
	
	part imagingSubsystem {
		perform takePicture.shoot;
	}
}

%viz Camera""")

for r in res:
    if r['msg_type'] == 'execute_result' and 'text/plain' in r['content']['data']:
        print(r['content']['data']['text/plain'])

kc.stop_channels()
km.shutdown_kernel()
