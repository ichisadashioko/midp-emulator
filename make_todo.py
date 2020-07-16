package_root = './src/main/java/javax/microedition/lcdui/game/'

classes = [
    #=== javax.microedition.io
    # 'CommConnection',
    # 'Connection',
    # 'ConnectionNotFoundException',
    # 'Connector',
    # 'ContentConnection',
    # 'Datagram',
    # 'DatagramConnection',
    # 'HttpConnection',
    # 'HttpsConnection',
    # 'InputConnection',
    # 'OutputConnection',
    # 'PushRegistry',
    # 'SecureConnection',
    # 'SecurityInfo',
    # 'ServerSocketConnection',
    # 'SocketConnection',
    # 'StreamConnection',
    # 'StreamConnectionNotifier',
    # 'UDPDatagramConnection',
    #=== javax.microedition.lcdui.game
    # 'GameCanvas',
    # 'Layer',
    # 'LayerManager',
    # 'Sprite',
    # 'TiledLayer',
    #=== javax.microedition.rms
    'RecordComparator',
    'RecordEnumeration',
    'RecordFilter',
    'RecordListener',
    'RecordStore',
    'InvalidRecordIDException',
    'RecordStoreException',
    'RecordStoreFullException',
    'RecordStoreNotFoundException',
    'RecordStoreNotOpenException',
    #=== javax.microedition.midlet
    # 'MIDlet',
    # 'MIDletStateChangeException',
    #=== javax.microedition.media.control
    # 'ToneControl',
    # 'VolumeControl',
    #=== javax.microedition.pki
    # 'Certificate',
    # 'CertificateException',
]

for c in classes:
    print(f'- [ ] `{c}`')
