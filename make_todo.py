package_root = './src/main/java/javax/microedition/lcdui/game/'

classes = [
    # 'GameCanvas',
    # 'Layer',
    # 'LayerManager',
    # 'Sprite',
    # 'TiledLayer',
    # 'RecordComparator',
    # 'RecordEnumeration',
    # 'RecordFilter',
    # 'RecordListener',
    # 'RecordStore',
    # 'InvalidRecordIDException',
    # 'RecordStoreException',
    # 'RecordStoreFullException',
    # 'RecordStoreNotFoundException',
    # 'RecordStoreNotOpenException',
    # 'MIDlet',
    # 'MIDletStateChangeException',
    # 'ToneControl',
    # 'VolumeControl',
    'Certificate',
    'CertificateException',
]

for c in classes:
    print(f'- [ ] [`{c}`]({package_root}{c}.java)')