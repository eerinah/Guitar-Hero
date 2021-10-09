# Guitar-Hero
Using keyboard input, the program plays musical notes that mimic the sound of guitar strings using a ring buffer and the Karplus-Strong algorithm. 

## Motivation 
Desire to better understand how to design and use a ring buffer made of a priority queue. 

## Ring Buffers to Mimic Guitar Strings 
The ring buffer data structure allows us to mimick guitar strings using the Karplus-Strong algorithm. It averages the frequencies of the vibrations when the guitar string is plucked

### Ring Buffer 
The ring buffer object is the implementation of Queue as a ring buffer. It has two pointers that keep track of the index for the next dequeue or peek and the index for the next enqueue in the ring buffer. When an element is enqueued and the queue has reached the last index, the index for enqueuing loops back to index 0. When an element is dequeued, the index of dequeueing loops back to index 0. 

### Guitar String

A GuitarString object models the behavior of a guitar string using a ring buffer.

A guitar string's vibration frequency is determined by the length of the string. It's vibration can be derived by sampling the string's displacement at each N, sampling rate (44100 Hz) and dividing it by the string's fundamental frequency. 

Plucking the guitar string can be modeled by setting each N displacements with a random number between -0.5 and 0.5.

In a guitar string, the displacements spread wave-like over time. This spread can be modeled through the Karplus-Strong algorithm by a ring buffer of N samples (sampling rate / fundamental frequency). The Karplus-Strong Algorithm takes The ring buffer contains the value of the displacement of the string once plucked. When it's plucked, an element from the ring buffer is dequeued, and a new random displacement is enqueued. Continuously, the simulation gets advanced as the first two elements that are dequeued are averaged and mulitplied by an energy decay factor, mimicking the decrease in displacement of the vibrations in the string over time. 

### Guitar Hero
The Guitar Hero program corresponds certain keys on the user's keyboard to music notes that can be plucked. When keys are pressed, the corresponding guitar keys are plucked and the superposition of their samples are played through the StdAudio library.
