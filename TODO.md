## User Interface Package

### `javax.microedition.lcdui`: The UI API provides a set of features for implementation of user interfaces for MIDP applications.

__Interfaces__

- [ ] [`Choice`](./src/main/java/javax/microedition/lcdui/Choice.java)
- [ ] [`CommandListener`](./src/main/java/javax/microedition/lcdui/CommandListener.java)
- [ ] [`ItemCommandListener`](./src/main/java/javax/microedition/lcdui/ItemCommandListener.java)
- [ ] [`ItemStateListener`](./src/main/java/javax/microedition/lcdui/ItemStateListener.java)

__Classes__

- [ ] [`Alert`](./src/main/java/javax/microedition/lcdui/Alert.java)
- [ ] [`AlertType`](./src/main/java/javax/microedition/lcdui/AlertType.java)
- [ ] [`Canvas`](./src/main/java/javax/microedition/lcdui/Canvas.java)
- [ ] [`ChoiceGroup`](./src/main/java/javax/microedition/lcdui/ChoiceGroup.java)
- [ ] [`Command`](./src/main/java/javax/microedition/lcdui/Command.java)
- [ ] [`CustomItem`](./src/main/java/javax/microedition/lcdui/CustomItem.java)
- [ ] [`DateField`](./src/main/java/javax/microedition/lcdui/DateField.java)
- [ ] [`Display`](./src/main/java/javax/microedition/lcdui/Display.java)
- [ ] [`Displayable`](./src/main/java/javax/microedition/lcdui/Displayable.java)
- [ ] [`Font`](./src/main/java/javax/microedition/lcdui/Font.java)
- [ ] [`Form`](./src/main/java/javax/microedition/lcdui/Form.java)
- [ ] [`Gauge`](./src/main/java/javax/microedition/lcdui/Gauge.java)
- [ ] [`Graphics`](./src/main/java/javax/microedition/lcdui/Graphics.java)
- [ ] [`Image`](./src/main/java/javax/microedition/lcdui/Image.java)
- [ ] [`ImageItem`](./src/main/java/javax/microedition/lcdui/ImageItem.java)
- [ ] [`Item`](./src/main/java/javax/microedition/lcdui/Item.java)
- [ ] [`List`](./src/main/java/javax/microedition/lcdui/List.java)
- [ ] [`Screen`](./src/main/java/javax/microedition/lcdui/Screen.java)
- [ ] [`Spacer`](./src/main/java/javax/microedition/lcdui/Spacer.java)
- [ ] [`StringItem`](./src/main/java/javax/microedition/lcdui/StringItem.java)
- [ ] [`TextBox`](./src/main/java/javax/microedition/lcdui/TextBox.java)
- [ ] [`TextField`](./src/main/java/javax/microedition/lcdui/TextField.java)
- [ ] [`Ticker`](./src/main/java/javax/microedition/lcdui/Ticker.java)

### `javax.microedition.lcdui.game`: The Game API package provides a series of classes that enable the development of rich gaming content for wireless devices.

__Classes__

- [ ] [`GameCanvas`](./src/main/java/javax/microedition/lcdui/game/GameCanvas.java)
- [ ] [`Layer`](./src/main/java/javax/microedition/lcdui/game/Layer.java)
- [ ] [`LayerManager`](./src/main/java/javax/microedition/lcdui/game/LayerManager.java)
- [ ] [`Sprite`](./src/main/java/javax/microedition/lcdui/game/Sprite.java)
- [ ] [`TiledLayer`](./src/main/java/javax/microedition/lcdui/game/TiledLayer.java)

## Persistence Package

### `javax.microedition.rms`: The Mobile Information Device Profile provides a mechanism for MIDlets to persistently store data and later retrieve it.

__Interfaces__

- [ ] [`RecordComparator`](./src/main/java/javax/microedition/rms/RecordComparator.java)
- [ ] [`RecordEnumeration`](./src/main/java/javax/microedition/rms/RecordEnumeration.java)
- [ ] [`RecordFilter`](./src/main/java/javax/microedition/rms/RecordFilter.java)
- [ ] [`RecordListener`](./src/main/java/javax/microedition/rms/RecordListener.java)

__Classes__

- [ ] [`RecordStore`](./src/main/java/javax/microedition/rms/RecordStore.java)

__Exceptions__

- [ ] [`InvalidRecordIDException`](./src/main/java/javax/microedition/rms/InvalidRecordIDException.java)
- [ ] [`RecordStoreException`](./src/main/java/javax/microedition/rms/RecordStoreException.java)
- [ ] [`RecordStoreFullException`](./src/main/java/javax/microedition/rms/RecordStoreFullException.java)
- [ ] [`RecordStoreNotFoundException`](./src/main/java/javax/microedition/rms/RecordStoreNotFoundException.java)
- [ ] [`RecordStoreNotOpenException`](./src/main/java/javax/microedition/rms/RecordStoreNotOpenException.java)

## Application Lifecycle Package

### `javax.microedition.midlet`: The MIDlet package defines Mobile Information Device Profile applications and the interactions between the application and the environment in which the application runs.

__Classes__

- [ ] [`MIDlet`](./src/main/java/javax/microedition/midlet/MIDlet.java)

__Exceptions__

- [ ] [`MIDletStateChangeException`](./src/main/java/javax/microedition/midlet/MIDletStateChangeException.java)

## Networking Package

### `javax.microedition.io`: Classes for the Generic Connection framework.

__Interfaces__

- [ ] [`CommConnection`](./src/main/java/javax/microedition/io/CommConnection.java)
- [ ] [`Connection`](./src/main/java/javax/microedition/io/Connection.java)
- [ ] [`ContentConnection`](./src/main/java/javax/microedition/io/ContentConnection.java)
- [ ] [`Datagram`](./src/main/java/javax/microedition/io/Datagram.java)
- [ ] [`DatagramConnection`](./src/main/java/javax/microedition/io/DatagramConnection.java)
- [ ] [`HttpConnection`](./src/main/java/javax/microedition/io/HttpConnection.java)
- [ ] [`HttpsConnection`](./src/main/java/javax/microedition/io/HttpsConnection.java)
- [ ] [`InputConnection`](./src/main/java/javax/microedition/io/InputConnection.java)
- [ ] [`OutputConnection`](./src/main/java/javax/microedition/io/OutputConnection.java)
- [ ] [`SecureConnection`](./src/main/java/javax/microedition/io/SecureConnection.java)
- [ ] [`SecurityInfo`](./src/main/java/javax/microedition/io/SecurityInfo.java)
- [ ] [`ServerSocketConnection`](./src/main/java/javax/microedition/io/ServerSocketConnection.java)
- [ ] [`SocketConnection`](./src/main/java/javax/microedition/io/SocketConnection.java)
- [ ] [`StreamConnection`](./src/main/java/javax/microedition/io/StreamConnection.java)
- [ ] [`StreamConnectionNotifier`](./src/main/java/javax/microedition/io/StreamConnectionNotifier.java)
- [ ] [`UDPDatagramConnection`](./src/main/java/javax/microedition/io/UDPDatagramConnection.java)

__Classes__

- [ ] [`Connector`](./src/main/java/javax/microedition/io/Connector.java)
- [ ] [`PushRegistry`](./src/main/java/javax/microedition/io/PushRegistry.java)

__Exceptions__

- [ ] [`ConnectionNotFoundException`](./src/main/java/javax/microedition/io/ConnectionNotFoundException.java)

## Audio Package

### `javax.microedition.media`: The MIDP 2.0 Media API is a directly compatible building block of the Mobile Media API (JSR-135) specification.

__Interfaces__

- [ ] [`Control`](./src/main/java/javax/microedition/media/Control.java)
- [ ] [`Controllable`](./src/main/java/javax/microedition/media/Controllable.java)
- [ ] [`Player`](./src/main/java/javax/microedition/media/Player.java)
- [ ] [`PlayerListener`](./src/main/java/javax/microedition/media/PlayerListener.java)

__Classes__

- [ ] [`Manager`](./src/main/java/javax/microedition/media/Manager.java)

__Exceptions__

- [ ] [`MediaException`](./src/main/java/javax/microedition/media/MediaException.java)

### `javax.microedition.media.control`: This package defines the specific `Control` types that can be used with a `Player`.

__Interfaces__

- [ ] [`ToneControl`](./src/main/java/javax/microedition/media/control/ToneControl.java)
- [ ] [`VolumeControl`](./src/main/java/javax/microedition/media/control/VolumeControl.java)

## Public Key Package

### `javax.microedition.pki`: Certificates are used to authenticate information for secure Connections.

__Interfaces__

- [ ] [`Certificate`](./src/main/java/javax/microedition/pki/Certificate.java)

__Exceptions__

- [ ] [`CertificateException`](./src/main/java/javax/microedition/pki/CertificateException.java)
