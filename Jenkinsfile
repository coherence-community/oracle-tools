pipeline {
    agent none
    stages {
        stage('compile') {
            agent {
              label 'linux'
            }
            steps {
                withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                   sh 'mvn -DskipTests clean install'
                }
            }
        }
        stage('test') {
            parallel {
                stage('bedrock-core') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-core clean install'
                        }
                    }
                }
                stage('Coherence 3.7.1 Tests') {
                    agent {
                        label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                            sh 'mvn -am -Djava.net.preferIPv4Stack=true -pl bedrock-coherence/3.7.1/coherence-3.7.1-tests clean install'
                        }
                    }
                }
                stage('Coherence 12.1.2 Tests') {
                    agent {
                        label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                            sh 'mvn -am -Djava.net.preferIPv4Stack=true -pl bedrock-coherence/12.1.2/coherence-12.1.2-tests clean install'
                        }
                    }
                }
                stage('Coherence 12.1.3 Tests') {
                    agent {
                        label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                            sh 'mvn -am -Djava.net.preferIPv4Stack=true -pl bedrock-coherence/12.1.3/coherence-12.1.3-tests clean install'
                        }
                    }
                }
                stage('Coherence 12.2.1 Tests') {
                    agent {
                        label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                            sh 'mvn -am -Djava.net.preferIPv4Stack=true -pl bedrock-coherence/12.2.1/coherence-12.2.1-tests clean install'
                        }
                    }
                }
                stage('Coherence 12.2.1.4 Tests') {
                    agent {
                        label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                            sh 'mvn -am -Djava.net.preferIPv4Stack=true -pl bedrock-coherence/12.2.1.4/coherence-12.2.1.4-tests clean install'
                        }
                    }
                }
                stage('bedrock-runtime-docker-tests') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-runtime-docker-tests clean install'
                        }
                    }
                }
                stage('bedrock-runtime-jacoco') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-runtime-jacoco clean install'
                        }
                    }
                }
                stage('bedrock-runtime-jprofiler') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-runtime-jprofiler clean install'
                        }
                    }
                }
                stage('bedrock-runtime-k8s') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-runtime-k8s clean install'
                        }
                    }
                }
                stage('bedrock-runtime-vagrant-tests') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-runtime-vagrant-tests clean install'
                        }
                    }
                }
                stage('bedrock-runtime-virtual-tests') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-runtime-virtual-tests clean install'
                        }
                    }
                }
                stage('bedrock-runtime-windows-tests') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-runtime-windows-tests clean install'
                        }
                    }
                }
                stage('bedrock-testing-support-tests') {
                    agent {
                      label 'linux'
                    }
                    steps {
                        withMaven(jdk: 'Jdk8', maven: 'Maven3.6.0', mavenSettingsConfig: 'maven-settings', tempBinDir: '') {
                           sh 'mvn -am -pl bedrock-testing-support-tests clean install'
                        }
                    }
                }
            }
        }
    }
}
