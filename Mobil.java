import greenfoot.*;

public class Mobil extends Actor
{
    private GreenfootImage[] frames; // Array untuk menyimpan frame dari sprite sheet
    private int frameIndex; // Indeks frame saat ini
    private int frameDelay = 5; // Jeda antara perubahan frame
    private int delayCount = 0; // Hitung jeda saat ini

    public Mobil() {
        // Memuat sprite sheet
        GreenfootImage spriteSheet = new GreenfootImage("spritesheet .png");
        
        // Mendefinisikan jumlah frame dan inisialisasi array frames
        int totalFrames = 5; // Jumlah total frame pada spritesheet
        frames = new GreenfootImage[totalFrames];
        
        // Mengisi array frames dengan frame-frame dari sprite sheet
        int frameWidth = spriteSheet.getWidth() / totalFrames; // Menghitung lebar setiap frame
        int frameHeight = spriteSheet.getHeight(); // Tinggi frame sama dengan tinggi sprite sheet
        
        for (int i = 0; i < totalFrames; i++) {
            frames[i] = new GreenfootImage(frameWidth, frameHeight);
            frames[i].drawImage(spriteSheet, -i * frameWidth, 0);
        }
        
        // Set frame awal
        setImage(frames[0]);
        frameIndex = 0; // Set frameIndex ke 0 saat awal
    }

    public void act()
    {
        // Mengubah frame setiap kali delayCount mencapai frameDelay
        if (!Greenfoot.isKeyDown("a") && !Greenfoot.isKeyDown("d")) {
            // Jika tidak ada tombol yang ditekan, tampilkan frame terakhir yang ditampilkan sebelumnya
            setImage(frames[frameIndex]);
        } else if (delayCount >= frameDelay) {
            // Jika tombol "a" atau "d" ditekan, atur animasi berjalan
            frameIndex = (frameIndex + 1) % frames.length;
            setImage(frames[frameIndex]);
            delayCount = 0; // Reset delayCount setelah mengubah frame
        } else {
            delayCount++; // Meningkatkan delayCount jika belum saatnya mengubah frame
        }
    }
}
