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

run_cell("package PictureTaking {\n\tpart def Exposure;\n\taction def Focus { out xrsl: Exposure; }\n\taction def Shoot { in xsf: Exposure; }\n\taction takePicture {\n\t\taction focus: Focus[1];\n\t\tflow of Exposure from focus.xrsl to shoot.xsf;\n\t\taction shoot: Shoot[1];\n\t}\n}")
run_cell("part def Camera {\n\tprivate import PictureTaking::*;\n\tperform action takePicture[*] :> PictureTaking::takePicture;\n\tpart focusingSubsystem {\n\t\tperform takePicture.focus;\n\t}\n\tpart imagingSubsystem {\n\t\tperform takePicture.shoot;\n\t}\n}")
res = run_cell("%viz Camera")
for r in res:
    print(r)

kc.stop_channels()
km.shutdown_kernel()
