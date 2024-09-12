package com.mini.builder;

class Computer {
    private String CPU;
    private String RAM;
    private String storage;
    private String GPU;

    // 私有构造函数，避免直接使用构造函数创建对象
    private Computer(ComputerBuilder builder) {
        this.CPU = builder.CPU;
        this.RAM = builder.RAM;
        this.storage = builder.storage;
        this.GPU = builder.GPU;
    }

    @Override
    public String toString() {
        return "Computer [CPU=" + CPU + ", RAM=" + RAM + ", Storage=" + storage + ", GPU=" + GPU + "]";
    }

    // 静态的 Builder 内部类
    public static class ComputerBuilder {
        private String CPU;
        private String RAM;
        private String storage;
        private String GPU;

        public ComputerBuilder(String CPU, String RAM) {
            this.CPU = CPU;
            this.RAM = RAM;
        }

        public ComputerBuilder setStorage(String storage) {
            this.storage = storage;
            return this;
        }

        public ComputerBuilder setGPU(String GPU) {
            this.GPU = GPU;
            return this;
        }

        // 构建 Computer 对象
        public Computer build() {
            return new Computer(this);
        }
    }
}
