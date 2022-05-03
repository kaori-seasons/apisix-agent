maven_settings ?= ${HOME}/.m2/settings.xml
snapshotId=snapshots
releaseId=releases
HOME_DIR=${HOME}/.apisix-plugin-agent

default: package

install: package dist-to-home

dist-to-home:
	@rm -rf ${HOME_DIR}/*.jar
	@mkdir -p ${HOME_DIR}
	cp apisix-plugin-core/target/apisix-plugin-core-jar-with-dependencies.jar ${HOME_DIR}/apisix-plugin-core.jar
	cp apisix-plugin-agent/target/apisix-plugin-agent-jar-with-dependencies.jar ${HOME_DIR}/apisix-plugin-agent.jar
	cp apisix-plugin-server/target/apisix-plugin-server-jar-with-dependencies.jar ${HOME_DIR}/apisix-plugin-server.jar
	cp apisix-plugin-watcher/target/apisix-plugin-watcher.jar ${HOME_DIR}/apisix-plugin-watcher.jar

package:
	mvn --settings=${maven_settings} clean package -Dmaven.test.skip=true -P full
